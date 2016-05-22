package com.company.restaurant.model.jdbc;

import com.company.restaurant.model.Course;
import com.company.restaurant.model.Menu;
import com.company.restaurant.model.MenuCourseList;
import com.company.restaurant.model.MenuCoursesListDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yevhen on 21.05.2016.
 */
public class JdbcMenuCoursesListDao extends JdbcDaoLinkTable<MenuCourseList> implements MenuCoursesListDao {
    private static final String MENU_COURSES_LIST_TABLE_NAME = "menu_courses_list";
    private static final String MENU_ID_FIELD_NAME = "menu_id";
    private static final String COURSE_ID_FIELD_NAME = "course_id";
    private static final String COURSE_NUMBER_FIELD_NAME = "course_number";

    public JdbcMenuCoursesListDao() {
        this.tableName = MENU_COURSES_LIST_TABLE_NAME;
        this.firstIdFieldName = MENU_ID_FIELD_NAME;
        this.secondIdFieldName = COURSE_ID_FIELD_NAME;
    }

    private int getMaxCourseNumberInMenu(Menu menu) {
        String selectResult = getOneFieldByFieldCondition(String.format(SQL_MAX_STATEMENT, COURSE_NUMBER_FIELD_NAME),
                firstIdFieldName, menu.getId());

        return (selectResult == null) || selectResult.equals("") ? 0 : Integer.parseInt(selectResult);
    }

    @Override
    protected Map<String, Object> objectToDBMap(MenuCourseList menuCourseList) {
        HashMap<String, Object> result = new HashMap<>();

        result.put(COURSE_NUMBER_FIELD_NAME, menuCourseList.getCourseNumber());

        return result;
    }

    @Override
    protected MenuCourseList newObject(ResultSet resultSet) throws SQLException {
        MenuCourseList result = new MenuCourseList();
        result.setFirstId(resultSet.getInt(firstIdFieldName));
        result.setSecondId(resultSet.getInt(secondIdFieldName));
        result.setCourseNumber(resultSet.getInt(COURSE_NUMBER_FIELD_NAME));

        return result;
    }

    @Override
    public void addCourseToMenu(Menu menu, Course course) {
        int firstId = menu.getId();
        int secondId = course.getCourseId();

        MenuCourseList menuCourseList = new MenuCourseList();
        menuCourseList.setFirstId(firstId);
        menuCourseList.setSecondId(secondId);
        menuCourseList.setCourseNumber(getMaxCourseNumberInMenu(menu) + 1);

        addRecord(firstId, secondId, menuCourseList);
    }

    @Override
    public void delCourseFromMenu(Menu menu, Course course) {
        delRecord(menu.getId(), course.getCourseId());
    }
}
