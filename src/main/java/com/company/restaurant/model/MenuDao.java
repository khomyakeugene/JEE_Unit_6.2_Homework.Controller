package com.company.restaurant.model;

import java.util.List;

/**
 * Created by Yevhen on 20.05.2016.
 */
public interface MenuDao {
    Menu addMenu(String name);

    String delMenu(String name);

    String delMenu(Menu menu);

    Menu findMenuByName(String name);

    Menu findMenuById(int menuId);

    List<Menu> findAllMenus();

    void addCourseToMenu(Menu menu, Course course);

    void delCourseFromMenu(Menu menu, Course course);

    List<MenuCourseList> findMenuCourses(Menu menu);
}
