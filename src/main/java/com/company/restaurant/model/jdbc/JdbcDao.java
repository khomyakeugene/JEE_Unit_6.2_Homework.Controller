package com.company.restaurant.model.jdbc;

import com.company.util.DataNotFoundException;

import javax.sql.DataSource;
import java.sql.*;

/**
 * Created by Yevhen on 19.05.2016.
 */
public class JdbcDao<T> {
    private static final String CANNOT_FIND_DATA_BY_INT_PATTERN = "Cannot find data with \"%s\" = %d";
    private static final String CANNOT_FIND_DATA_BY_STRING_PATTERN = "Cannot find data with \"%s\" = \"%s\"";

    private static final String SQL_ALL_FIELD_BY_FIELD_VALUE = "SELECT * FROM %s WHERE (%s = ?)";

    protected String tableName;
    protected DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    protected void databaseConnectError(Exception e) {
        throw new RuntimeException(e);
    }

    protected ResultSet findByInt(String fieldName, int value, boolean throwDataNotFoundException) {
        ResultSet resultSet = null;

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    String.format(SQL_ALL_FIELD_BY_FIELD_VALUE, tableName, fieldName))) {
            preparedStatement.setInt(1, value);
            resultSet = preparedStatement.executeQuery();

            // To first record in the data set
            if (!resultSet.next()) {
                if (throwDataNotFoundException) {
                    throw new DataNotFoundException(String.format(CANNOT_FIND_DATA_BY_INT_PATTERN, fieldName, value));
                }
            } else {
                // As an indication that data was not found
                resultSet = null;
            }
        } catch (SQLException e) {
            databaseConnectError(e);
        }

        return resultSet;
    }

    protected ResultSet findByString(String fieldName, String value, boolean throwDataNotFoundException) {
        ResultSet resultSet = null;

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    String.format(SQL_ALL_FIELD_BY_FIELD_VALUE, tableName, fieldName))) {
            preparedStatement.setString(1, value);
            resultSet = preparedStatement.executeQuery();

            // To first record in the data set
            if (!resultSet.next()) {
                if (throwDataNotFoundException) {
                    throw new DataNotFoundException(String.format(CANNOT_FIND_DATA_BY_STRING_PATTERN, fieldName, value));
                } else {
                    // As an indication that data was not found
                    resultSet = null;
                }
            }
        } catch (SQLException e) {
            databaseConnectError(e);
        }

        return resultSet;
    }
}
