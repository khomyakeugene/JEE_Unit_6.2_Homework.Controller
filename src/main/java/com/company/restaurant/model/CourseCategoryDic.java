package com.company.restaurant.model;

/**
 * Created by Yevhen on 21.05.2016.
 */
public class CourseCategoryDic {
    private int courseCategoryId;
    private String name;

    public CourseCategoryDic(int courseCategoryId, String name) {
        this.courseCategoryId = courseCategoryId;
        this.name = name;
    }

    public int getCourseCategoryId() {
        return courseCategoryId;
    }

    public void setCourseCategoryId(int courseCategoryId) {
        this.courseCategoryId = courseCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
