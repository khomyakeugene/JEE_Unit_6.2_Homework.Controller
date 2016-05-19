package com.company.restaurant.model.jdbc;

import javax.sql.DataSource;

/**
 * Created by Yevhen on 19.05.2016.
 */
public class JdbcDao<T> {
    protected static final String CANNOT_FIND_DATA_BY_INT_PATTERN = "Cannot find data with \"%s\" = %d";
    protected static final String CANNOT_FIND_DATA_BY_STRING_PATTERN = "Cannot find data with \"%s\" = \"%s\"";

    protected DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    protected void databaseConnectError(Exception e) {
        throw new RuntimeException(e);
    }
}
