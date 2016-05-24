package com.company.restaurant.model;

/**
 * Created by Yevhen on 23.05.2016.
 */
public class OrderCourse extends IntegerLinkObject {
    private int courseCategoryId;
    private String courseName;
    private float courseWeight;
    private float courseCost;
    private String courseCategoryName;

    public int getCourseId() {
        return getFirstId();
    }

    public void setCourseId(int courseId) {
        setFirstId(courseId);
    }

    public int getOrderId() {
        return getSecondId();
    }

    public void setOrderId(int orderId) {
        setSecondId(orderId);
    }

    public int getCourseQuantity() {
        return getIntegerLinkData();
    }

    public void setCourseQuantity(int courseQuantity) {
        setIntegerLinkData(courseQuantity);
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCourseCategoryId() {
        return courseCategoryId;
    }

    public void setCourseCategoryId(int courseCategoryId) {
        this.courseCategoryId = courseCategoryId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public float getCourseWeight() {
        return courseWeight;
    }

    public void setCourseWeight(float courseWeight) {
        this.courseWeight = courseWeight;
    }

    public float getCourseCost() {
        return courseCost;
    }

    public void setCourseCost(float courseCost) {
        this.courseCost = courseCost;
    }

    public String getCourseCategoryName() {
        return courseCategoryName;
    }

    public void setCourseCategoryName(String courseCategoryName) {
        this.courseCategoryName = courseCategoryName;
    }
}
