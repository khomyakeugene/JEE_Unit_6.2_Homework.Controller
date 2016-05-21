package com.company.restaurant.model;

import java.util.List;

/**
 * Created by Yevhen on 21.05.2016.
 */
public interface CourseCategoryDao {
    CourseCategory addCourseCategory(String name);

    void delCourseCategory(String name);

    CourseCategory findCourseCategoryByName(String name);

    List<CourseCategory> findAllCourseCategories();
}
