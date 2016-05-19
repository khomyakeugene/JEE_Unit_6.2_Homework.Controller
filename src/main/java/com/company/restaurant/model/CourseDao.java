package com.company.restaurant.model;

import java.util.List;

/**
 * Created by Yevhen on 19.05.2016.
 */
public interface CourseDao {
    int createCourse(int categoryId, String name, float weight, float cost);

    void deleteCourse(int courseId);

    Course findCourseByName(String name);

    List<Course> findAllCourses();

}
