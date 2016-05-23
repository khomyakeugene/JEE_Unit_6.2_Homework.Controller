package com.company.restaurant.model;

import java.util.List;

/**
 * Created by Yevhen on 23.05.2016.
 */
public interface CookedCourseDao {
    void addCookedCourse(Course course, Employee employee, float weight);

    void delCookedCourse(CookedCourse cookedCourse);

    List<CookedCourse> findAllCookedCourses();
}
