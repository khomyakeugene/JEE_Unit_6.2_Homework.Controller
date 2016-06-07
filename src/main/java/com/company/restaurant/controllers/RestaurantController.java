package com.company.restaurant.controllers;

import com.company.restaurant.dao.MenuDao;
import com.company.restaurant.dao.TableDao;
import com.company.restaurant.model.Course;
import com.company.restaurant.model.Menu;
import com.company.restaurant.model.MenuCourseList;
import com.company.restaurant.model.Table;

import java.util.List;

/**
 * Created by Yevhen on 19.05.2016.
 */
public class RestaurantController extends BasicTransactionManagerController {
    private MenuDao menuDao;
    private TableDao tableDao;

    public void setMenuDao(MenuDao menuDao) {
        this.menuDao = menuDao;
    }

    public void setTableDao(TableDao tableDao) {
        this.tableDao = tableDao;
    }

    public Menu addMenu(String name) {
        return menuDao.addMenu(name);
    }

    public String delMenu(String name) {
        return menuDao.delMenu(name);
    }

    public String delMenu(Menu menu) {
        return menuDao.delMenu(menu);
    }

    public Menu findMenuByName(String name) {
        return menuDao.findMenuByName(name);
    }

    public Menu findMenuById(int menuId) {
        return menuDao.findMenuById(menuId);
    }

    public List<Menu> findAllMenus() {
        return menuDao.findAllMenus();
    }

    public void addCourseToMenu(Menu menu, Course course) {
        menuDao.addCourseToMenu(menu, course);
    }

    public void delCourseFromMenu(Menu menu, Course course) {
        menuDao.delCourseFromMenu(menu, course);
    }

    public List<MenuCourseList> findMenuCourses(Menu menu) {
        return menuDao.findMenuCourses(menu);
    }

    public MenuCourseList findMenuCourseByCourseId(Menu menu, int courseId) {
        return menuDao.findMenuCourseByCourseId(menu, courseId);
    }

    public Table addTable(Table table) {
        return tableDao.addTable(table);
    }

    public String delTable(Table table) {
        return tableDao.delTable(table);
    }

    public Table findTableById(int tableId) {
        return tableDao.findTableById(tableId);
    }

    public Table findTableByNumber(int number) {
        return tableDao.findTableByNumber(number);
    }

    public List<Table> findAllTables() {
        return tableDao.findAllTables();
    }
}
