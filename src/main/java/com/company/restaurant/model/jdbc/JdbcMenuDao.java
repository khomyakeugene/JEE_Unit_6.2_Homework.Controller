package com.company.restaurant.model.jdbc;

import com.company.restaurant.model.Course;
import com.company.restaurant.model.Menu;
import com.company.restaurant.model.MenuDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yevhen on 20.05.2016.
 */
public class JdbcMenuDao extends JdbcDaoTable<Menu> implements MenuDao {
    private static final String MENU_TABLE_NAME = "menu";
    private static final String MENU_ID_FIELD_NAME = "course_id";
    private static final String NAME_FIELD_NAME = "name";
    private static final String DEFAULT_ORDER_BY_CONDITION = "ORDER BY name";

    public JdbcMenuDao() {
        this.tableName = MENU_TABLE_NAME;
        this.idFieldName = MENU_ID_FIELD_NAME;
        this.nameFieldName = NAME_FIELD_NAME;
        this.orderByCondition = DEFAULT_ORDER_BY_CONDITION;
    }

    @Override
    protected Menu newObject(ResultSet resultSet) throws SQLException {
        return new Menu(resultSet.getInt(MENU_ID_FIELD_NAME), resultSet.getString(NAME_FIELD_NAME));
    }


    @Override
    protected void setGeneratedId(int id, Menu menu) {
        menu.setMenuId(id);
    }

    @Override
    protected Map<String, Object> objectToDBMap(Menu menu) {
        HashMap<String, Object> result = new HashMap<>();

        result.put(NAME_FIELD_NAME, menu.getName());

        return result;
    }

    @Override
    public int addMenu(Menu menu) {
        return addRecord(menu);
    }

    @Override
    public void delMenu(Menu menu) {
        delRecord(menu);
    }

    @Override
    public void delMenu(String name) {
        delRecordByName(name);
    }

    @Override
    public Menu findMenuByName(String name) {
        return findObjectByName(name);
    }

    @Override
    public List<Menu> findAllMenus() {
        return findAllObjects();
    }

    @Override
    public int addCourseToMenu(String menuName, Course course) {
        return 0;
    }

    @Override
    public void delCourseFromMenu(String menuName, Course course) {

    }
}
