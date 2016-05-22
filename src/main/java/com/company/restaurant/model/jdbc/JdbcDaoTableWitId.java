package com.company.restaurant.model.jdbc;

import com.company.util.DataIntegrityException;

import java.sql.*;
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

    public void delRecord(T object) {
        Map<String, Object> objectToDBMap = objectToDBMap(object);

        String fieldName = idFieldName;
        Object value = objectToDBMap.get(fieldName);
        if (value == null) {
            fieldName = nameFieldName;
            value = objectToDBMap.get(fieldName);
            if (value == null) {
                throw new DataIntegrityException(String.format(CANNOT_DELETE_RECORD_PATTERN, tableName, idFieldName, nameFieldName));
            }
        }

        // Actually, delete teh record by suitable condition
        delRecordByFieldCondition(fieldName, value);
    }

    public void delRecordById(int id) {
        delRecordByFieldCondition(idFieldName, id);
    }

    public void delRecordByName(String name) {
        delRecordByFieldCondition(nameFieldName, name);
    }
}
