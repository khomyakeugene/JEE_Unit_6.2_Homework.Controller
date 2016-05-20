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
    protected DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    protected void databaseError(Exception e) {
        throw new RuntimeException(e);
    }

    public static String toString(Object object) {
        String result = object.toString();

        if (object instanceof String) {
            result =  "'" + result + "'";
        }

        return result;
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

    protected List<T> createObjectListFromQuery(String query) {
        ArrayList<T> result = new ArrayList<>();

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result.add(createObject(resultSet));
            }
        } catch (SQLException e) {
            databaseError(e);
        }

        return result;
    }

    protected T createObjectFromQuery(String query) {
        List<T> objectList = createObjectListFromQuery(query);

        return (objectList.size() > 0) ? objectList.get(0) : null;
    }
}