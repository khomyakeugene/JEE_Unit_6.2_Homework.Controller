package com.company.restaurant.model.jdbc;

import com.company.restaurant.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Yevhen on 23.05.2016.
 */
public class JdbcOrderCourseDao extends JdbcDaoQuantityLinkTable<OrderCourse> implements OrderCourseDao {
    private static final String ORDER_COURSE_TABLE_NAME = "order_course";
    private static final String ORDER_COURSE_VIEW_NAME = "v_order_course";
    private static final String COURSE_ID_FIELD_NAME = "course_id";
    private static final String ORDER_ID_FIELD_NAME = "order_id";
    private static final String QUANTITY_FIELD_NAME = "quantity";
    private static final String COURSE_QUANTITY_FIELD_NAME = "course_quantity";
    private static final String COURSE_CATEGORY_ID_FIELD_NAME = "course_category_id";
    private static final String COURSE_NAME_FIELD_NAME = "course_name";
    private static final String COURSE_WEIGHT_FIELD_NAME = "course_weight";
    private static final String COURSE_COST_FIELD_NAME = "course_cost";
    private static final String COURSE_CATEGORY_NAME_FIELD_NAME = "course_category_name";
    private static final String DEFAULT_ORDER_BY_CONDITION = "ORDER BY course_name";

    public JdbcOrderCourseDao() {
        this.tableName = ORDER_COURSE_TABLE_NAME;
        this.viewName = ORDER_COURSE_VIEW_NAME;
        this.firstIdFieldName = COURSE_ID_FIELD_NAME;
        this.secondIdFieldName = ORDER_ID_FIELD_NAME;
        this.thirdFieldName = QUANTITY_FIELD_NAME;
    }

    @Override
    protected OrderCourse newObject(ResultSet resultSet) throws SQLException {
        OrderCourse result = new OrderCourse();
        result.setCourseId(resultSet.getInt(COURSE_ID_FIELD_NAME));
        result.setOrderId(resultSet.getInt(ORDER_ID_FIELD_NAME));
        result.setCourseQuantity(resultSet.getInt(COURSE_QUANTITY_FIELD_NAME));
        result.setCourseCategoryId(resultSet.getInt(COURSE_CATEGORY_ID_FIELD_NAME));
        result.setCourseName(resultSet.getString(COURSE_NAME_FIELD_NAME));
        result.setCourseWeight(resultSet.getFloat(COURSE_WEIGHT_FIELD_NAME));
        result.setCourseCost(resultSet.getFloat(COURSE_COST_FIELD_NAME));
        result.setCourseCategoryName(resultSet.getString(COURSE_CATEGORY_NAME_FIELD_NAME));

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
    public List<OrderCourse> findAllOrderCourses(Order order) {
        return findObjectsByFieldCondition(ORDER_ID_FIELD_NAME, order.getOrderId());
    }
}
