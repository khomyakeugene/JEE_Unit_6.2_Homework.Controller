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

    @Override
    protected void initMetadata() {
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
    public String delMenu(String name) {
        return delRecordByName(name);
    }

    @Override
    public String delMenu(Menu menu) {
        return delRecord(menu);
    }

    @Override
    public Menu findMenuByName(String name) {
        return findObjectByName(name);
    }

    @Override
    public Menu findMenuById(int menuId) {
        return findObjectById(menuId);
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

    @Override
    public MenuCourseList findMenuCourseByCourseId(Menu menu, int courseId) {
        return menuCourseListDao.findMenuCourseByCourseId(menu, courseId);
    }
}
