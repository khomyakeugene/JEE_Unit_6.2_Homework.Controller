package com.company.restaurant.model.jdbc;

import com.company.restaurant.model.LinkObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yevhen on 21.05.2016.
 */
public class JdbcDaoLinkTable<T extends LinkObject> extends JdbcDao<T> {
    private static final String SQL_INSERT_EXPRESSION_PATTERN = "INSERT INTO %s (%s, %s) VALUES(%d, %d)";

    protected String tableName;
    protected String firstIdFieldName;
    protected String secondIdFieldName;

    protected T newObject() {
        return (T)(new LinkObject());
    }

    public void addRecord(int firstId, int secondId) {
        executeUpdate(String.format(SQL_INSERT_EXPRESSION_PATTERN, tableName, firstIdFieldName,
                secondIdFieldName, firstId, secondId));
    }

    @Override
    protected T newObject(ResultSet resultSet) throws SQLException {
        T object = newObject();
        object.setFirstId(resultSet.getInt(firstIdFieldName));
        object.setSecondId(resultSet.getInt(secondIdFieldName));

        return object;
    }
}
