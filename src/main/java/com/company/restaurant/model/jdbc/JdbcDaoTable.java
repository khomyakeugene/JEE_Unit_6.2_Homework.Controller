package com.company.restaurant.model.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

/**
 * Created by Yevhen on 21.05.2016.
 */
public abstract class JdbcDaoTable<T> extends JdbcDao<T> {
    private static final String SQL_ALL_FIELD_OF_ALL_RECORDS = "SELECT * FROM %s";
    private static final String SQL_ALL_FIELD_BY_FIELD_VALUE = "SELECT * FROM %s WHERE (%s = %s)";
    private static final String SQL_SELECT_BY_TWO_FIELD_VALUE = "SELECT %s FROM %s WHERE (%s = %s) AND (%s = %s)";
    private static final String SQL_DELETE_EXPRESSION_PATTERN = "DELETE FROM %s WHERE (%s = %s)";

    protected String tableName;
    protected String orderByCondition;

    protected abstract Map<String, Object> objectToDBMap(T object);

    private String orderByCondition() {
        return (orderByCondition == null) ? "" : orderByCondition;
    }

    private String allQueryCondition() {
        return String.format(SQL_ALL_FIELD_OF_ALL_RECORDS, tableName) + " " + orderByCondition();
    }

    private String fieldQueryCondition(String fieldName, Object value) {
        return String.format(SQL_ALL_FIELD_BY_FIELD_VALUE, tableName, fieldName, JdbcDao.toString(value)) + " " +
                orderByCondition();
    }

    protected String twoFieldsQueryCondition(String fieldName_1, Object value_1, String fieldName_2, Object value_2,
                                           String selectFields) {
        return String.format(SQL_SELECT_BY_TWO_FIELD_VALUE, selectFields, tableName, fieldName_1, JdbcDao.toString(value_1),
                fieldName_2, JdbcDao.toString(value_2)) + " " + orderByCondition();
    }

    private String twoFieldsQueryCondition(String fieldName_1, Object value_1, String fieldName_2, Object value_2) {
        return twoFieldsQueryCondition(fieldName_1, value_1, fieldName_2, value_2, "*");
    }

    public T findObjectByFieldCondition(String fieldName, Object value) {
        return createObjectFromQuery(fieldQueryCondition(fieldName, value));
    }

    protected List<T> findObjectsByFieldCondition(String fieldName, Object value) {
        return createObjectListFromQuery(fieldQueryCondition(fieldName, value));
    }

    protected T findObjectByTwoFieldCondition(String fieldName_1, Object value_1, String fieldName_2, Object value_2) {
        return createObjectFromQuery(twoFieldsQueryCondition(fieldName_1, value_1, fieldName_2, value_2));
    }

    protected List<T> findObjectsByTwoFieldCondition(String fieldName_1, Object value_1, String fieldName_2, Object value_2) {
        return createObjectListFromQuery(twoFieldsQueryCondition(fieldName_1, value_1, fieldName_2, value_2));
    }

    protected List<T> findAllObjects() {
        return createObjectListFromQuery(allQueryCondition());
    }

    private String buildDeleteExpression(String fieldName, Object value) {
        return String.format(SQL_DELETE_EXPRESSION_PATTERN, tableName, fieldName, JdbcDao.toString(value));
    }

    public void delRecordByFieldCondition(String fieldName, Object value) {
        try(Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement()) {
            statement.executeUpdate(buildDeleteExpression(fieldName, value));
        } catch (SQLException e) {
            databaseError(e);
        }
    }

    protected String buildInsertExpression(String pattern, T object) {
        Map<String, Object> objectToDBMap = objectToDBMap(object);

        String fieldSequence = String.join(",",
                (CharSequence[])objectToDBMap.keySet().stream().toArray(String[]::new));
        String valueSequence = String.join(",",
                (CharSequence[])objectToDBMap.values().stream().map(v -> (JdbcDao.toString(v))).toArray(String[]::new));

        return String.format(pattern, fieldSequence, valueSequence);
    }
}
