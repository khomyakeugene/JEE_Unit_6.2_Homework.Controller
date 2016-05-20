package com.company.restaurant.model.jdbc;

import com.company.util.Util;

import java.util.List;

/**
 * Created by Yevhen on 19.05.2016.
 */
public abstract class JdbcDaoTable<T> extends JdbcDao<T> {
    private static final String SQL_ALL_FIELD_OF_ALL_RECORDS = "SELECT * FROM %s";
    private static final String SQL_ALL_FIELD_BY_FIELD_VALUE = "SELECT * FROM %s WHERE (%s = %s)";
    private static final String SQL_ALL_FIELD_BY_TWO_FIELD_VALUE = "SELECT * FROM %s WHERE (%s = %s) AND (%s = %s)";

    protected String tableName;
    protected String idFieldName;
    protected String nameFieldName;
    protected String orderByCondition;

    private String orderByCondition() {
        return (orderByCondition == null) ? "" : orderByCondition;
    }

    private String allQueryCondition() {
        return String.format(SQL_ALL_FIELD_OF_ALL_RECORDS, tableName) + " " + orderByCondition();
    }

    private String fieldQueryCondition(String fieldName, Object value) {
        return String.format(SQL_ALL_FIELD_BY_FIELD_VALUE, tableName, fieldName, Util.toString(value)) + " " +
                orderByCondition();
    }

    private String twoFieldsQueryCondition(String fieldName_1, Object value_1, String fieldName_2, Object value_2) {
        return String.format(SQL_ALL_FIELD_BY_TWO_FIELD_VALUE, tableName, fieldName_1, Util.toString(value_1),
                fieldName_2, Util.toString(value_2)) + " " + orderByCondition();
    }

    protected T findObjectByFieldCondition(String fieldName, Object value) {
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

    public T findObjectById(int id) {
        return findObjectByFieldCondition(idFieldName, id);
    }

    public T findObjectByName(String name) {
        return findObjectByFieldCondition(nameFieldName, name);
    }
}
