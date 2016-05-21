package com.company.restaurant.model;

import java.util.List;

/**
 * Created by Yevhen on 21.05.2016.
 */
public interface CourseCategoryDicDao {
    int addCourseCategory(String name);

    void delCourseCategory(String name);

    CourseCategoryDic findCourseCategoryByName(String name);

    List<CourseCategoryDic> findAllCourseCategories();
}
