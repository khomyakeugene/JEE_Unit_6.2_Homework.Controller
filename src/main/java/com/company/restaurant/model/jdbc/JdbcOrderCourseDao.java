package com.company.restaurant.model.jdbc;

import com.company.restaurant.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Yevhen on 23.05.2016.
 */
public class JdbcOrderCourseDao extends JdbcDaoQuantityLinkTable<OrderCourse> implements OrderCourseDao {
    private static final String ORDER_COURSE_TABLE_NAME = "order_course";
    private static final String COURSE_ID_FIELD_NAME = "course_id";
    private static final String ORDER_ID_FIELD_NAME = "order_id";
    private static final String QUANTITY_FIELD_NAME = "quantity";

    public JdbcOrderCourseDao() {
        this.tableName = ORDER_COURSE_TABLE_NAME;
        this.firstIdFieldName = COURSE_ID_FIELD_NAME;
        this.secondIdFieldName = ORDER_ID_FIELD_NAME;
        this.thirdFieldName = QUANTITY_FIELD_NAME;
    }

    @Override
    protected OrderCourse newObject(ResultSet resultSet) throws SQLException {
        OrderCourse result = new OrderCourse();
        result.setFirstId(resultSet.getInt(firstIdFieldName));
        result.setSecondId(resultSet.getInt(secondIdFieldName));
        result.setIntegerLinkData(resultSet.getInt(thirdFieldName));

        return result;
    }

    @Override
    public void addCourseToOrder(Order order, Course course, int quantity) {
        increaseQuantity(course.getCourseId(), order.getOrderId(), quantity);
    }

    @Override
    public void takeCourseFromOrder(Order order, Course course, int quantity) {
        decreaseQuantity(course.getCourseId(), order.getOrderId(), quantity);
    }

    @Override
    public void takeCourseFromOrder(Order order, Course course) {
        takeCourseFromOrder(order, course, 1);
    }
}
