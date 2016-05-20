package com.company.restaurant.model;

/**
 * Created by Yevhen on 19.05.2016.
 */
public class Course {
    private int courseId;
    private int categoryId;
    private String name;
    private float weight;
    private float cost;

    public Course(int courseId, int categoryId, String name, float weight, float cost) {
        this.courseId = courseId;
        this.categoryId = categoryId;
        this.name = name;
        this.weight = weight;
        this.cost = cost;
    }
}
