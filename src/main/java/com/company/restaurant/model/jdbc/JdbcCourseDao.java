package com.company.restaurant.model.jdbc;

import com.company.restaurant.model.Course;
import com.company.restaurant.model.CourseDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Yevhen on 20.05.2016.
 */
public class JdbcCourseDao extends JdbcDaoTable<Course> implements CourseDao {
    private static final String COURSE_TABLE_NAME = "course";
    private static final String COURSE_ID_FIELD_NAME = "course_id";
    private static final String CATEGORY_ID_FIELD_NAME = "category_id";
    private static final String NAME_FIELD_NAME = "name";
    private static final String WEIGHT_FIELD_NAME = "weight";
    private static final String COST_FIELD_NAME = "cost";
    private static final String DEFAULT_ORDER_BY_CONDITION = "ORDER BY name";

    public JdbcCourseDao() {
        this.tableName = COURSE_TABLE_NAME;
        this.idFieldName = COURSE_ID_FIELD_NAME;
        this.nameFieldName = NAME_FIELD_NAME;
        this.orderByCondition = DEFAULT_ORDER_BY_CONDITION;
    }

    @Override
    protected Course newObject(ResultSet resultSet) throws SQLException {
        return new Course(resultSet.getInt(COURSE_ID_FIELD_NAME), resultSet.getInt(CATEGORY_ID_FIELD_NAME),
                resultSet.getString(NAME_FIELD_NAME), resultSet.getFloat(WEIGHT_FIELD_NAME),
                resultSet.getFloat(COST_FIELD_NAME));
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
        return findObjectByName(name);
    }

    @Override
    public List<Course> findAllCourses() {
        return findAllObjects();
    }
}
