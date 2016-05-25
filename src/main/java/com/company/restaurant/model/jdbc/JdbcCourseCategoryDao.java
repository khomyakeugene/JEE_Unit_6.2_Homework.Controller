package com.company.restaurant.model.jdbc;

import com.company.restaurant.model.CourseCategory;
import com.company.restaurant.model.CourseCategoryDao;

import java.util.List;

/**
 * Created by Yevhen on 21.05.2016.
 */
public class JdbcCourseCategoryDao extends JdbcDaoTableSimpleDic<CourseCategory> implements CourseCategoryDao {
    private static final String COURSE_CATEGORY_DIC_TABLE_NAME = "course_category_dic";
    private static final String COURSE_CATEGORY_ID_FIELD_NAME = "course_category_id";

    @Override
    protected void initMetadata() {
        this.tableName = COURSE_CATEGORY_DIC_TABLE_NAME;
        this.idFieldName = COURSE_CATEGORY_ID_FIELD_NAME;
    }

    @Override
    protected CourseCategory newObject() {
        return new CourseCategory();
    }

    @Override
    public CourseCategory addCourseCategory(String name) {
        return addRecord(name);
    }

    @Override
    public String delCourseCategory(String name) {
        return delRecordByName(name);
    }

    @Override
    public CourseCategory findCourseCategoryByName(String name) {
        return findObjectByName(name);
    }

    @Override
    public List<CourseCategory> findAllCourseCategories() {
        return findAllObjects();
    }
}
