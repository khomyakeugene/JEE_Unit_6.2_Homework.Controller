package com.company.restaurant.model;

import java.util.List;

/**
 * Created by Yevhen on 20.05.2016.
 */
public interface MenuDao {
    int addMenu(String name);

    void delMenu(String name);

    Menu findMenuByName(String name);

    List<Menu> findAllMenus();

    void addCourseToMenu(String menuName, Course course);

    void delCourseFromMenu(String menuName, Course course);
}