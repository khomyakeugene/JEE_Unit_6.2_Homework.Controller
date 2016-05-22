package com.company.restaurant.model;

/**
 * Created by Yevhen on 23.05.2016.
 */
public interface OrderCourseDao {
    void addCourseToOrder(Order order, Course course, int quantity);

    void delCourseFromOrder(Order order, Course course);
}
