package com.company.restaurant.model.jdbc;

import com.company.restaurant.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yevhen on 23.05.2016.
 */
public class JdbcOrderCourseDao extends JdbcDaoLinkTable<OrderCourse> implements OrderCourseDao {
    private static final String ORDER_COURSE_TABLE_NAME = "order_course";
    private static final String COURSE_ID_FIELD_NAME = "course_id";
    private static final String ORDER_ID_FIELD_NAME = "order_id";
    private static final String QUANTITY_FIELD_NAME = "quantity";

    public JdbcOrderCourseDao() {
        this.tableName = ORDER_COURSE_TABLE_NAME;
        this.firstIdFieldName = COURSE_ID_FIELD_NAME;
        this.secondIdFieldName = ORDER_ID_FIELD_NAME;
    }

    @Override
    protected Map<String, Object> objectToDBMap(OrderCourse orderCourse) {
        HashMap<String, Object> result = new HashMap<>();

        result.put(QUANTITY_FIELD_NAME, orderCourse.getQuantity());

        return result;
    }

    @Override
    protected OrderCourse newObject(ResultSet resultSet) throws SQLException {
        OrderCourse result = new OrderCourse();
        result.setFirstId(resultSet.getInt(firstIdFieldName));
        result.setSecondId(resultSet.getInt(secondIdFieldName));
        result.setQuantity(resultSet.getInt(QUANTITY_FIELD_NAME));

        return result;
    }

    @Override
    public void addCourseToOrder(Order order, Course course, int quantity) {
        int firstId = course.getCourseId();
        int secondId = order.getOrderId();

        OrderCourse orderCourse = new OrderCourse();
        orderCourse.setFirstId(firstId);
        orderCourse.setSecondId(secondId);
        orderCourse.setQuantity(quantity);

        addRecord(firstId, secondId, orderCourse);
    }

    @Override
    public void delCourseFromOrder(Order order, Course course) {
        delRecord(course.getCourseId(), order.getOrderId());
    }
}
