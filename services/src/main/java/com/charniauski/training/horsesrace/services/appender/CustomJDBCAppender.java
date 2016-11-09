package com.charniauski.training.horsesrace.services.appender;

/**
 * Created by Andre on 31.10.2016.
 */

import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.appender.db.AbstractDatabaseAppender;
import org.apache.logging.log4j.core.appender.db.jdbc.ColumnConfig;
import org.apache.logging.log4j.core.appender.db.jdbc.ConnectionSource;
import org.apache.logging.log4j.core.appender.db.jdbc.JdbcDatabaseManager;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.util.Booleans;

// note: class name need not match the @Plugin name.
@Plugin(name = "JDBCAppender", category = "Core", elementType = "appender", printObject = true)
public final class CustomJDBCAppender extends AbstractDatabaseAppender<CustomJdbcDatabaseManager> {
    private static final long serialVersionUID = 1L;

    private final String description;

    private CustomJDBCAppender(final String name, final Filter filter, final boolean ignoreExceptions,
                         final CustomJdbcDatabaseManager manager) {
        super(name, filter, ignoreExceptions, manager);
        this.description = this.getName() + "{ manager=" + this.getManager() + " }";
    }

    @Override
    public String toString() {
        return this.description;
    }

    /**
     * Factory method for creating a JDBC appender within the plugin manager.
     *
     * @param name The name of the appender.
     * @param ignore If {@code "true"} (default) exceptions encountered when appending events are logged; otherwise
     *               they are propagated to the caller.
     * @param filter The filter, if any, to use.
     * @param connectionSource The connections source from which database connections should be retrieved.
     * @param bufferSize If an integer greater than 0, this causes the appender to buffer log events and flush whenever
     *                   the buffer reaches this size.
     * @param tableName The name of the database table to insert log events into.
     * @param columnConfigs Information about the columns that log event data should be inserted into and how to insert
     *                      that data.
     * @return a new JDBC appender.
     */
    @PluginFactory
    public static CustomJDBCAppender createAppender(
            @PluginAttribute("name") final String name,
            @PluginAttribute("ignoreExceptions") final String ignore,
            @PluginElement("Filter") final Filter filter,
            @PluginElement("ConnectionSource") final ConnectionSource connectionSource,
            @PluginAttribute("bufferSize") final String bufferSize,
            @PluginAttribute("tableName") final String tableName,
            @PluginElement("ColumnConfigs") final ColumnConfig[] columnConfigs) {

        final int bufferSizeInt = AbstractAppender.parseInt(bufferSize, 0);
        final boolean ignoreExceptions = Booleans.parseBoolean(ignore, true);

        final StringBuilder managerName = new StringBuilder("jdbcManager{ description=").append(name)
                .append(", bufferSize=").append(bufferSizeInt).append(", connectionSource=")
                .append(connectionSource.toString()).append(", tableName=").append(tableName).append(", columns=[ ");

        int i = 0;
        for (final ColumnConfig column : columnConfigs) {
            if (i++ > 0) {
                managerName.append(", ");
            }
            managerName.append(column.toString());
        }

        managerName.append(" ] }");

        final CustomJdbcDatabaseManager manager = CustomJdbcDatabaseManager.getJDBCDatabaseManager(
                managerName.toString(), bufferSizeInt, connectionSource, tableName, columnConfigs
        );
        if (manager == null) {
            return null;
        }

        return new CustomJDBCAppender(name, filter, ignoreExceptions, manager);
    }
}