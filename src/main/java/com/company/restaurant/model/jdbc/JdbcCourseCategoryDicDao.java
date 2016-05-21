package com.company.restaurant.model.jdbc;

import com.company.restaurant.model.CourseCategoryDic;
import com.company.restaurant.model.CourseCategoryDicDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Yevhen on 21.05.2016.
 */
public class JdbcCourseCategoryDicDao extends JdbcDaoTableSimpleDic<CourseCategoryDic> implements CourseCategoryDicDao {
    private static final String COURSE_CATEGORY_DIC_TABLE_NAME = "course_category_dic";
    private static final String COURSE_CATEGORY_ID_FIELD_NAME = "course_category_id";
    private static final String NAME_FIELD_NAME = "name";
    private static final String DEFAULT_ORDER_BY_CONDITION = "ORDER BY name";

    public JdbcCourseCategoryDicDao() {
        this.tableName = COURSE_CATEGORY_DIC_TABLE_NAME;
        this.idFieldName = COURSE_CATEGORY_ID_FIELD_NAME;
        this.nameFieldName = NAME_FIELD_NAME;
        this.orderByCondition = DEFAULT_ORDER_BY_CONDITION;
    }

    @Override
    protected CourseCategoryDic newObject() {
        return new CourseCategoryDic();
    }

    @Override
    public int addCourseCategory(String name) {
        return addRecord(name);
    }

    @Override
    public void delCourseCategory(String name) {
        delRecordByName(name);
    }

    @Override
    public CourseCategoryDic findCourseCategoryByName(String name) {
        return findObjectByName(name);
    }

    @Override
    public List<CourseCategoryDic> findAllCourseCategories() {
        return findAllObjects();
    }
}
