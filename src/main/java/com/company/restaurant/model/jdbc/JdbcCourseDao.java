package com.company.restaurant.model.jdbc;

import com.company.restaurant.model.Course;
import com.company.restaurant.model.CourseCategoryDao;
import com.company.restaurant.model.CourseDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yevhen on 20.05.2016.
 */
public class JdbcCourseDao extends JdbcDaoTableWitId<Course> implements CourseDao {
    private static final String COURSE_TABLE_NAME = "course";
    private static final String COURSE_VIEW_NAME = "v_course";
    private static final String COURSE_ID_FIELD_NAME = "course_id";
    private static final String COURSE_CATEGORY_ID_FIELD_NAME = "course_category_id";
    private static final String NAME_FIELD_NAME = "name";
    private static final String WEIGHT_FIELD_NAME = "weight";
    private static final String COST_FIELD_NAME = "cost";
    private static final String COURSE_CATEGORY_NAME_FIELD_NAME = "course_category_name";
    private static final String DEFAULT_ORDER_BY_CONDITION = "ORDER BY name";

    private CourseCategoryDao courseCategoryDao;

    @Override
    protected void initMetadata() {
        this.tableName = COURSE_TABLE_NAME;
        this.viewName = COURSE_VIEW_NAME;
        this.idFieldName = COURSE_ID_FIELD_NAME;
        this.nameFieldName = NAME_FIELD_NAME;
        this.orderByCondition = DEFAULT_ORDER_BY_CONDITION;
    }

    public void setCourseCategoryDao(CourseCategoryDao courseCategoryDao) {
        this.courseCategoryDao = courseCategoryDao;
    }

    @Override
    protected Course newObject(ResultSet resultSet) throws SQLException {
        Course result = new Course();
        result.setCourseId(resultSet.getInt(COURSE_ID_FIELD_NAME));
        result.setCategoryId(resultSet.getInt(COURSE_CATEGORY_ID_FIELD_NAME));
        result.setName(resultSet.getString(NAME_FIELD_NAME));
        result.setWeight(resultSet.getFloat(WEIGHT_FIELD_NAME));
        result.setCost(resultSet.getFloat(COST_FIELD_NAME));
        result.setCourseCategoryName(resultSet.getString(COURSE_CATEGORY_NAME_FIELD_NAME));

        return result;
    }

    @Override
    protected Map<String, Object> objectToDBMap(Course course) {
        HashMap<String, Object> result = new HashMap<>();

        result.put(COURSE_CATEGORY_ID_FIELD_NAME, course.getCategoryId());
        result.put(NAME_FIELD_NAME, course.getName());
        result.put(WEIGHT_FIELD_NAME, course.getWeight());
        result.put(COST_FIELD_NAME, course.getCost());

        return result;
    }

    @Override
    public Course findCourseByName(String name) {
        return findObjectByName(name);
    }

    @Override
    public List<Course> findAllCourses() {
        return findAllObjects();
    }

    @Override
    protected void setId(int id, Course course) {
        course.setCourseId(id);
    }

    @Override
    public Course addCourse(Course course) {
        return addRecord(course);
    }

    @Override
    public void delCourse(Course course) {
        delRecord(course);
    }

    @Override
    public void delCourse(String name) {
        delRecordByName(name);
    }
}
