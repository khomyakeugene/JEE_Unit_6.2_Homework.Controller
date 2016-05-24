package com.company.restaurant.model;

/**
 * Created by Yevhen on 21.05.2016.
 */
public class MenuCourseList extends IntegerLinkObject {
    private int courseCategoryId;
    private String courseName;
    private float courseWeight;
    private float courseCost;
    private String courseCategoryName;

    public int getMenuId() {
        return getFirstId();
    }

    public void setMenuId(int orderId) {
        setFirstId(orderId);
    }

    public int getCourseId() {
        return getSecondId();
    }

    public void setCourseId(int courseId) {
        setSecondId(courseId);
    }

    public int getCourseNumber() {
        return getIntegerLinkData();
    }

    public void setCourseNumber(int courseNumber) {
        setIntegerLinkData(courseNumber);
    }

    public int getCourseCategoryId() {
        return courseCategoryId;
    }

    public void setCourseCategoryId(int courseCategoryId) {
        this.courseCategoryId = courseCategoryId;
    }

    public String getCourseName() {
        return courseName;
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
