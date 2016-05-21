package com.company.restaurant.model.jdbc;

import com.company.restaurant.model.LinkObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

/**
 * Created by Yevhen on 21.05.2016.
 */
public abstract class JdbcDaoLinkTable<T extends LinkObject> extends JdbcDaoTable<T> {
    private static final String SQL_INSERT_EXPRESSION_PATTERN_PART_1 = "INSERT INTO %s (%s, %s";
    private static final String SQL_INSERT_EXPRESSION_PATTERN_PART_2 = "VALUES(%d, %d";
    private static final String SQL_DELETE_EXPRESSION_PATTERN = "DELETE FROM %s WHERE (%s = %d) AND (%s = %d)";

    protected String firstIdFieldName;
    protected String secondIdFieldName;

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

    public void delRecord(int firstId, int secondId) {
        executeUpdate(String.format(SQL_DELETE_EXPRESSION_PATTERN, tableName, firstIdFieldName, firstId,
                secondIdFieldName, secondId));
    }

    private String twoFieldsQueryCondition(String selectFields, int firstId, int secondId) {
        return twoFieldsQueryCondition(firstIdFieldName, Integer.toString(firstId), secondIdFieldName,
                Integer.toString(secondId), selectFields);
    }

    public String getOneFieldByTwoFieldCondition(String selectFields, int firstId, int secondId) {
        String result = null;

        try(Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(twoFieldsQueryCondition(selectFields, firstId, secondId));
            if (resultSet.next()) {
                result = resultSet.getString(1);
            }
        } catch (SQLException e) {
            databaseError(e);
        }

        return result;
    }
}
