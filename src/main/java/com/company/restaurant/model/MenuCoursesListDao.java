package com.company.restaurant.model;

import java.util.List;

/**
 * Created by Yevhen on 21.05.2016.
 */
public interface MenuCoursesListDao {
    void addCourseToMenu(Menu menu, Course course);

    String delCourseFromMenu(Menu menu, Course course);

    List<MenuCourseList> findMenuCourses(Menu menu);
}
