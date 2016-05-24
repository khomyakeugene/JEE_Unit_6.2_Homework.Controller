package com.company.restaurant.model;

import java.util.List;

/**
 * Created by Yevhen on 19.05.2016.
 */
public interface CourseDao {
    Course addCourse(Course course);

    void delCourse(Course course);

    void delCourse(String name);

    Course findCourseByName(String name);

    List<Course> findAllCourses();

}
