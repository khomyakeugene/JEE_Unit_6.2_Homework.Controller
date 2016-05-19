package com.company.restaurant.model.jdbc;

import com.company.restaurant.model.Course;
import com.company.restaurant.model.CourseDao;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by Yevhen on 20.05.2016.
 */
public class JdbcCourseDao extends JdbcDaoTable<Course> implements CourseDao {
    private static final String COURSE_TABLE_NAME = "course";
    private static final String EMPLOYEE_ID_FIELD_NAME = "employee_id";
    private static final String POSITION_ID_FIELD_NAME = "position_id";
    private static final String FIRST_NAME_FIELD_NAME = "first_name";
    private static final String SECOND_NAME_FIELD_NAME = "second_name";
    private static final String PHONE_NUMBER_FIELD_NAME = "phone_number";
    private static final String SALARY_FIELD_NAME = "salary";
    private static final String DEFAULT_ORDER_BY_CONDITION = "ORDER BY name";

    public JdbcCourseDao() {
        this.tableName = COURSE_TABLE_NAME;
        this.orderByCondition = DEFAULT_ORDER_BY_CONDITION;
    }

    private Course createCourse(ResultSet resultSet) {
        return null;
    }

    @Override
    protected Course createObject(ResultSet resultSet) {
        return createCourse(resultSet);
    }

    @Override
    public int insertCourse(int categoryId, String name, float weight, float cost) {
        return 0;
    }

    @Override
    public void deleteCourse(int courseId) {

    }

    @Override
    public Course findCourseByName(String name) {
        return null;
    }

    @Override
    public List<Course> findAllCourses() {
        return null;
    }
}
