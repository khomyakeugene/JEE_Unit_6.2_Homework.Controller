package com.company.restaurant.model.jdbc;

import com.company.util.DataIntegrityException;

import java.sql.*;
import java.util.AbstractMap;
import java.util.Map;

/**
 * Created by Yevhen on 19.05.2016.
 */
public abstract class JdbcDaoTableWitId<T> extends JdbcDaoTable<T> {
    private static final String CANNOT_GET_LAST_GENERATED_ID_PATTERN = "Add record problem: cannot get last generated %s.%s value";
    private static final String CANNOT_DELETE_RECORD_PATTERN = "Cannot delete record in table <%s> because it is impossible " +
            "to detect condition value for field <%s> nor for field <%s>";
    private static final String SQL_INSERT_EXPRESSION_PATTERN_PART_1 = "INSERT INTO \"%s\"";
    private static final String SQL_INSERT_EXPRESSION_PATTERN_PART_2 = " (%s) VALUES(%s)";

    protected String idFieldName;
    protected String nameFieldName;

    protected abstract void setId(int id, T object);

    public T findObjectById(int id) {
        return findObjectByFieldCondition(idFieldName, id);
    }

    public T findObjectByName(String name) {
        return findObjectByFieldCondition(nameFieldName, name);
    }

    public int addRecord(T object) {
        int result = 0;

        try(Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement()) {

            String s = buildInsertExpression(String.format(SQL_INSERT_EXPRESSION_PATTERN_PART_1,
                    tableName) + SQL_INSERT_EXPRESSION_PATTERN_PART_2, object);

            statement.executeUpdate(s, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                result = resultSet.getInt(idFieldName);
                // Store new generated id in the added <object> - at least, it is important to support data integrity
                setId(result, object);
            } else  {
                throw new SQLException(String.format(CANNOT_GET_LAST_GENERATED_ID_PATTERN, tableName, idFieldName));
            }

        } catch (SQLException e) {
            databaseError(e);
        }

        return result;
    }

    private AbstractMap.SimpleEntry<String, Object> getKeyFieldNameAndFieldValue(T object) {
        Map<String, Object> objectToDBMap = getObjectToDBMap(object);

        String fieldName = idFieldName;
        Object fieldValue = objectToDBMap.get(fieldName);
        if (fieldValue == null) {
            fieldName = nameFieldName;
            fieldValue = objectToDBMap.get(fieldName);
            if (fieldValue == null) {
                throw new DataIntegrityException(String.format(CANNOT_DELETE_RECORD_PATTERN, tableName, idFieldName,
                        nameFieldName));
            }
        }

        return new AbstractMap.SimpleEntry<>(fieldName, fieldValue);
    }

    public void delRecord(T object) {
        AbstractMap.SimpleEntry<String, Object> fieldData = getKeyFieldNameAndFieldValue(object);

        delRecordByFieldCondition(fieldData.getKey(), fieldData.getValue());
    }

    public void delRecordById(int id) {
        delRecordByFieldCondition(idFieldName, id);
    }

    public void delRecordByName(String name) {
        delRecordByFieldCondition(nameFieldName, name);
    }

    public void updRecord(T object, String updateFieldName, Object updateFieldValue) {
        AbstractMap.SimpleEntry<String, Object> fieldData = getKeyFieldNameAndFieldValue(object);

        updateOneFieldByOneFieldCondition(updateFieldName, updateFieldValue, fieldData.getKey(), fieldData.getValue());
    }
}
