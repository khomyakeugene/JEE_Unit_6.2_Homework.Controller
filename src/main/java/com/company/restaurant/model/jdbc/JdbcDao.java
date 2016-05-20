package com.company.restaurant.model.jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yevhen on 19.05.2016.
 */
public abstract class JdbcDao<T> {
    protected static final String CANNOT_FIND_DATA_BY_INT_PATTERN = "Cannot find data with \"%s\" = %d";
    protected static final String CANNOT_FIND_DATA_BY_STRING_PATTERN = "Cannot find data with \"%s\" = \"%s\"";

    protected DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    protected void databaseError(Exception e) {
        throw new RuntimeException(e);
    }

    protected abstract T newObject(ResultSet resultSet) throws SQLException;

    private T createObject(ResultSet resultSet) {
        T result = null;

        if (resultSet != null) {
            try {
                result = newObject(resultSet);
            } catch (SQLException e) {
                databaseError(e);
            }
        }

        return result;
    }

    private ResultSet executeQuery(String query) {
        ResultSet resultSet = null;

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            databaseError(e);
        }

        return resultSet;
    }

    private List<T> createObjectList(ResultSet resultSet) {
        ArrayList<T> result = new ArrayList<>();

        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    result.add(createObject(resultSet));
                }
            } catch (SQLException e) {
                databaseError(e);
            }
        }

        return result;
    }

    protected T createObjectFromQuery(String query) {
        T result = null;

        ResultSet resultSet = executeQuery(query);
        try {
            result = resultSet.first() ? createObject(resultSet) : null;
        } catch (SQLException e) {
            databaseError(e);
        }

        return result;
    }

    protected List<T> createObjectListFromQuery(String query) {
        return createObjectList(executeQuery(query));
    }
}