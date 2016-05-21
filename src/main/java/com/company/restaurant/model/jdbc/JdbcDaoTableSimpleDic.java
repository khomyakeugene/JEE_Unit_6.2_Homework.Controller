package com.company.restaurant.model.jdbc;

import com.company.restaurant.model.SimpleDic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static java.awt.SystemColor.menu;

/**
 * Created by Yevhen on 21.05.2016.
 */
public abstract class JdbcDaoTableSimpleDic<T extends SimpleDic> extends JdbcDaoTable<T>  {
    protected abstract T newObject();

    @Override
    protected T newObject(ResultSet resultSet) throws SQLException {
        T object = newObject();
        object.setId(resultSet.getInt(idFieldName));
        object.setName(resultSet.getString(nameFieldName));

        return object;
    }

    @Override
    protected void setId(int id, T object) {
        object.setId(id);
    }

    public int addRecord(String name) {
        T object = newObject();
        object.setId(0);
        object.setName(name);

        return addRecord(object);
    }

    @Override
    protected Map<String, Object> objectToDBMap(T object) {
        HashMap<String, Object> result = new HashMap<>();

        result.put(nameFieldName, object.getName());

        return result;
    }
}
