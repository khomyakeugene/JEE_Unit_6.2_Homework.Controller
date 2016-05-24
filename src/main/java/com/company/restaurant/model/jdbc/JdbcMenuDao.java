package com.company.restaurant.model.jdbc;

import com.company.restaurant.model.*;

import java.util.List;

/**
 * Created by Yevhen on 20.05.2016.
 */
public class JdbcMenuDao extends JdbcDaoTableSimpleDic<Menu> implements MenuDao {
    private static final String MENU_TABLE_NAME = "menu";
    private static final String MENU_ID_FIELD_NAME = "menu_id";

    private MenuCoursesListDao menuCourseListDao;

    public void setMenuCourseListDao(MenuCoursesListDao menuCourseListDao) {
        this.menuCourseListDao = menuCourseListDao;
    }

    public JdbcMenuDao() {
        super();

        this.tableName = MENU_TABLE_NAME;
        this.idFieldName = MENU_ID_FIELD_NAME;
    }

    @Override
    protected Menu newObject() {
        return new Menu();
    }

    @Override
    public Menu addMenu(String name) {
        return addRecord(name);
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
    public void addCourseToMenu(Menu menu, Course course) {
        menuCourseListDao.addCourseToMenu(menu, course);
    }

    @Override
    public void delCourseFromMenu(Menu menu, Course course) {
        menuCourseListDao.delCourseFromMenu(menu, course);
    }

    @Override
    public List<MenuCourseList> findMenuCourses(Menu menu) {
        return menuCourseListDao.findMenuCourses(menu);
    }
}
