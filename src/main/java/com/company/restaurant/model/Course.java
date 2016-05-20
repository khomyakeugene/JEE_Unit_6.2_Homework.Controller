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

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}
