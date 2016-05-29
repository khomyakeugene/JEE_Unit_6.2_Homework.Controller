package com.company.restaurant.model;

import java.util.List;

/**
 * Created by Yevhen on 23.05.2016.
 */
public class KitchenAdapter {
    private CookedCourseDao cookedCourseDao;

    public void setCookedCourseDao(CookedCourseDao cookedCourseDao) {
        this.cookedCourseDao = cookedCourseDao;
    }

    public void addCookedCourse(Course course, Employee employee, Float weight) {
        cookedCourseDao.addCookedCourse(course, employee, weight);
    }

    public List<CookedCourse> findAllCookedCourses() {
        return cookedCourseDao.findAllCookedCourses();
    }
}
