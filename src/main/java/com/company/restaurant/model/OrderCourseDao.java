package com.company.restaurant.model;

import java.util.List;

/**
 * Created by Yevhen on 23.05.2016.
 */
public interface OrderCourseDao {
    void addCourseToOrder(Order order, Course course, int quantity);

    void takeCourseFromOrder(Order order, Course course, int quantity);

    List<OrderCourse> findAllOrderCourses(Order order);

    OrderCourse findOrderCourseByCourseId(Order order, int courseId);
}
