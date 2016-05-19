package com.company.restaurant.model.jdbc;

import com.company.restaurant.model.Course;
import com.company.restaurant.model.CourseDao;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by Yevhen on 20.05.2016.
 */
public class JdbcCourseDao extends JdbcDaoTable<Course> implements CourseDao {
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
