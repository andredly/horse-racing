package com.charniauski.training.horsesrace.daoxml.util;

import com.jolbox.bonecp.BoneCPDataSource;
import org.apache.commons.lang3.Validate;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SchemaNameAwareConnectionPool extends BoneCPDataSource {

    private String schema;

    /**
     * @return the schema
     */
    public String getSchema() {
        return schema;
    }

    /**
     * @param schema
     *            the schema to set
     */
    public void setSchema(final String schema) {
        Validate.notEmpty(schema, "Illegal schema name");
        this.schema = schema;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return switchSchema(super.getConnection());
    }

    @Override
    public Connection getConnection(final String username, final String password) throws SQLException {
        return switchSchema(super.getConnection(username, password));
    }

    private Connection switchSchema(final Connection connection) throws SQLException {
        final Statement stmt = connection.createStatement();
        try {
            stmt.execute("SET search_path TO " + schema);
        } finally {
            stmt.close();
        }

        return connection;
    }

}
