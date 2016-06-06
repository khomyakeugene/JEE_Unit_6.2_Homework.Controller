package com.company.restaurant.dao;

import com.company.restaurant.model.Course;
import com.company.restaurant.model.Menu;
import com.company.restaurant.model.MenuCourseList;

import java.util.List;

/**
 * Created by Yevhen on 21.05.2016.
 */
public interface MenuCoursesListDao {
    void addCourseToMenu(Menu menu, Course course);

    String delCourseFromMenu(Menu menu, Course course);

    List<MenuCourseList> findMenuCourses(Menu menu);

    MenuCourseList findMenuCourseByCourseId(Menu menu, int courseId);
}
