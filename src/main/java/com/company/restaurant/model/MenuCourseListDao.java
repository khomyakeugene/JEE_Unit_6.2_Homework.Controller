package com.company.restaurant.model;

/**
 * Created by Yevhen on 21.05.2016.
 */
public interface MenuCourseListDao {
    void addCourseToMenu(Menu menu, Course course);

    void delCourseFromMenu(Menu menu, Course course);
}
