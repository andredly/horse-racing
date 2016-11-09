package com.charniauski.training.horsesrace.services.appender;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AppenderLoggingException;
import org.apache.logging.log4j.core.appender.ManagerFactory;
import org.apache.logging.log4j.core.appender.db.AbstractDatabaseManager;
import org.apache.logging.log4j.core.appender.db.jdbc.ColumnConfig;
import org.apache.logging.log4j.core.appender.db.jdbc.ConnectionSource;
import org.apache.logging.log4j.core.appender.db.jdbc.JdbcAppender;
import org.apache.logging.log4j.core.appender.db.jdbc.JdbcDatabaseManager;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.apache.logging.log4j.core.util.Closer;

import java.io.StringReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andre on 09.11.2016.
 */
public class CustomJdbcDatabaseManager extends AbstractDatabaseManager {


    private static final CustomJdbcDatabaseManager.JdbcDatabaseManagerFactory INSTANCE = new CustomJdbcDatabaseManager.JdbcDatabaseManagerFactory();

    private final List<CustomJdbcDatabaseManager.Column> columns;
    private final ConnectionSource connectionSource;
    private final String sqlStatement;

    private Connection connection;
    private PreparedStatement statement;
    private boolean isBatchSupported;

    private CustomJdbcDatabaseManager(final String name, final int bufferSize, final ConnectionSource connectionSource,
                                final String sqlStatement, final List<CustomJdbcDatabaseManager.Column> columns) {
        super(name, bufferSize);
        this.connectionSource = connectionSource;
        this.sqlStatement = sqlStatement;
        this.columns = columns;
    }

    @Override
    protected void startupInternal() throws Exception {
        this.connection = this.connectionSource.getConnection();
        final DatabaseMetaData metaData = this.connection.getMetaData();
        this.isBatchSupported = metaData.supportsBatchUpdates();
        Closer.closeSilently(this.connection);
    }

    @Override
    protected void shutdownInternal() {
        if (this.connection != null || this.statement != null) {
            this.commitAndClose();
        }
    }

    @Override
    protected void connectAndStart() {
        try {
            this.connection = this.connectionSource.getConnection();
            this.connection.setAutoCommit(false);
            PreparedStatement preparedStatement = this.connection.prepareStatement(this.sqlStatement);
            preparedStatement.addBatch();
            this.statement = this.connection.prepareStatement(this.sqlStatement);
        } catch (final SQLException e) {
            throw new AppenderLoggingException(
                    "Cannot write logging event or flush buffer; JDBC manager cannot connect to the database.", e
            );
        }
    }

    @Override
    protected void writeInternal(final LogEvent event) {
        StringReader reader = null;
        try {
            if (!this.isRunning() || this.connection == null || this.connection.isClosed() || this.statement == null
                    || this.statement.isClosed()) {
                throw new AppenderLoggingException(
                        "Cannot write logging event; JDBC manager not connected to the database.");
            }

            int i = 1;
            for (final CustomJdbcDatabaseManager.Column column : this.columns) {
                if (column.isEventTimestamp) {
                    this.statement.setTimestamp(i++, new Timestamp(event.getTimeMillis()));
                } else {
                    if (column.isClob) {
                        reader = new StringReader(column.layout.toSerializable(event));
                        if (column.isUnicode) {
                            this.statement.setNClob(i++, reader);
                        } else {
                            this.statement.setClob(i++, reader);
                        }
                    } else {
                        if (column.isUnicode) {
                            this.statement.setNString(i++, column.layout.toSerializable(event));
                        } else {
                            this.statement.setString(i++, column.layout.toSerializable(event));
                        }
                    }
                }
            }

            if (this.isBatchSupported) {
                this.statement.addBatch();
            } else if (this.statement.executeUpdate() == 0) {
                throw new AppenderLoggingException(
                        "No records inserted in database table for log event in JDBC manager.");
            }
        } catch (final SQLException e) {
            throw new AppenderLoggingException("Failed to insert record for log event in JDBC manager: " +
                    e.getMessage(), e);
        } finally {
            Closer.closeSilently(reader);
        }
    }

    @Override
    protected void commitAndClose() {
        try {
            if (this.connection != null && !this.connection.isClosed()) {
                if (this.isBatchSupported) {
                    this.statement.addBatch();
                    this.statement.executeBatch();
                }
                this.connection.commit();
            }
        } catch (final SQLException e) {
            e.getNextException();
            e.printStackTrace();
            throw new AppenderLoggingException("Failed to commit transaction logging event or flushing buffer.", e);
        } finally {
            try {
                Closer.close(this.statement);
            } catch (final Exception e) {
                LOGGER.warn("Failed to close SQL statement logging event or flushing buffer.", e);
            } finally {
                this.statement = null;
            }

            try {
                Closer.close(this.connection);
            } catch (final Exception e) {
                LOGGER.warn("Failed to close database connection logging event or flushing buffer.", e);
            } finally {
                this.connection = null;
            }
        }
    }

    /**
     * Creates a JDBC manager for use within the {@link JdbcAppender}, or returns a suitable one if it already exists.
     *
     * @param name The name of the manager, which should include connection details and hashed passwords where possible.
     * @param bufferSize The size of the log event buffer.
     * @param connectionSource The source for connections to the database.
     * @param tableName The name of the database table to insert log events into.
     * @param columnConfigs Configuration information about the log table columns.
     * @return a new or existing JDBC manager as applicable.
     */
    public static CustomJdbcDatabaseManager getJDBCDatabaseManager(final String name, final int bufferSize,
                                                             final ConnectionSource connectionSource,
                                                             final String tableName,
                                                             final ColumnConfig[] columnConfigs) {

        return AbstractDatabaseManager.getManager(
                name, new CustomJdbcDatabaseManager.FactoryData(bufferSize, connectionSource, tableName, columnConfigs), getFactory()
        );
    }

    private static CustomJdbcDatabaseManager.JdbcDatabaseManagerFactory getFactory() {
        return INSTANCE;
    }

    /**
     * Encapsulates data that {@link JdbcDatabaseManager.JdbcDatabaseManagerFactory} uses to create managers.
     */
    private static final class FactoryData extends AbstractDatabaseManager.AbstractFactoryData {
        private final ColumnConfig[] columnConfigs;
        private final ConnectionSource connectionSource;
        private final String tableName;

        protected FactoryData(final int bufferSize, final ConnectionSource connectionSource, final String tableName,
                              final ColumnConfig[] columnConfigs) {
            super(bufferSize);
            this.connectionSource = connectionSource;
            this.tableName = tableName;
            this.columnConfigs = columnConfigs;
        }
    }

    /**
     * Creates managers.
     */
    private static final class JdbcDatabaseManagerFactory implements ManagerFactory<CustomJdbcDatabaseManager, CustomJdbcDatabaseManager.FactoryData> {
        @Override
        public CustomJdbcDatabaseManager createManager(final String name, final CustomJdbcDatabaseManager.FactoryData data) {
            final StringBuilder columnPart = new StringBuilder();
            final StringBuilder valuePart = new StringBuilder();
            final List<CustomJdbcDatabaseManager.Column> columns = new ArrayList<>();
            int i = 0;
            for (final ColumnConfig config : data.columnConfigs) {
                if (i++ > 0) {
                    columnPart.append(',');
                    valuePart.append(',');
                }

                columnPart.append(config.getColumnName());

                if (config.getLiteralValue() != null) {
                    valuePart.append(config.getLiteralValue());
                } else {
                    columns.add(new CustomJdbcDatabaseManager.Column(
                            config.getLayout(), config.isEventTimestamp(), config.isUnicode(), config.isClob()
                    ));
                    valuePart.append('?');
                }
            }

            final String sqlStatement = "INSERT INTO " + data.tableName + " (" + columnPart + ") VALUES (" +
                    valuePart + ')';

            return new CustomJdbcDatabaseManager(name, data.getBufferSize(), data.connectionSource, sqlStatement, columns);
        }
    }

    /**
     * Encapsulates information about a database column and how to persist data to it.
     */
    private static final class Column {
        private final PatternLayout layout;
        private final boolean isEventTimestamp;
        private final boolean isUnicode;
        private final boolean isClob;

        private Column(final PatternLayout layout, final boolean isEventDate, final boolean isUnicode,
                       final boolean isClob) {
            this.layout = layout;
            this.isEventTimestamp = isEventDate;
            this.isUnicode = isUnicode;
            this.isClob = isClob;
        }
    }
}
