package com.company.restaurant.model.jdbc;

import com.company.restaurant.model.LinkObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by Yevhen on 21.05.2016.
 */
public abstract class JdbcDaoLinkTable<T extends LinkObject> extends JdbcDaoTable<T> {
    private static final String SQL_INSERT_EXPRESSION_PATTERN_PART_1 = "INSERT INTO %s (%s, %s";
    private static final String SQL_INSERT_EXPRESSION_PATTERN_PART_2 = "VALUES(%d, %d";

    protected String firstIdFieldName;
    protected String secondIdFieldName;

    protected T newObject() {
        return (T)(new LinkObject());
    }

    @Override
    protected T newObject(ResultSet resultSet) throws SQLException {
        T object = newObject();
        object.setFirstId(resultSet.getInt(firstIdFieldName));
        object.setSecondId(resultSet.getInt(secondIdFieldName));

        return object;
    }

    public void addRecord(int firstId, int secondId, T object) {
        boolean isAdditionalData = objectToDBMap(object).size() > 0;

        String pattern = String.format(SQL_INSERT_EXPRESSION_PATTERN_PART_1, tableName, firstIdFieldName,
                secondIdFieldName);
        if (isAdditionalData) {
            pattern += ",%s";
        }
        pattern += ")";
        pattern += String.format(SQL_INSERT_EXPRESSION_PATTERN_PART_2, firstId, secondId);
        if (isAdditionalData) {
            pattern += ",%s";
        }
        pattern += ")";

        executeUpdate(buildInsertExpression(pattern, object));
    }
}
