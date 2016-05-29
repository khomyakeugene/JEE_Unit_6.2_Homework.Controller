package com.company.restaurant.model;

import com.company.util.DataIntegrityException;

import java.util.List;

/**
 * Created by Yevhen on 22.05.2016.
 */
public class OrderAdapter {
    private static final String IMPOSSIBLE_TO_DELETE_ORDER_PATTERN =
            "It is impossible to delete order in <%s> state (<order_id> = %d)!";
    private static final String IMPOSSIBLE_TO_ADD_COURSE_TO_ORDER_PATTERN =
            "It is impossible to add course to order in <%s> state (<order_id> = %d)!";
    private static final String IMPOSSIBLE_TO_DEL_COURSE_FROM_ORDER_PATTERN =
            "It is impossible to delete course from order in <%s> state (<order_id> = %d)!";

    private OrderDao orderDao;
    private StateGraphRules stateGraphRules;
    private OrderCourseDao orderCourseDao;

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void setStateGraphRules(StateGraphRules stateGraphRules) {
        this.stateGraphRules = stateGraphRules;
    }

    public void setOrderCourseDao(OrderCourseDao orderCourseDao) {
        this.orderCourseDao = orderCourseDao;
    }

    private String orderCreationState() {
        return stateGraphRules.creationState(orderDao.orderEntityName());
    }

    private String orderClosedState(Order order) {
        return stateGraphRules.closedState(orderDao.orderEntityName(), (order == null) ? null : order.getStateType());
    }

    private String orderClosedState() {
        return orderClosedState(null);
    }

    private String orderDeletedState(Order order) {
        return stateGraphRules.deletedState(orderDao.orderEntityName(), order.getStateType());
    }

    private boolean isFillingActionEnabled(Order order) {
        return stateGraphRules.isFillingActionEnabled(orderDao.orderEntityName(), order.getStateType());
    }

    private void errorMessage(String message) {
        throw new DataIntegrityException(message);
    }

    public Order addOrder(Order order) {
        order.setStateType(orderCreationState());

        return orderDao.addOrder(order);
    }

    public String delOrder(Order order) {
        boolean orderWasDeleted = false;
        String result = null;

        try {

            try {
                // Check if it is possible to delete (if <deleted state> is presented for this order)
                if (orderDeletedState(order) != null) {
                    result = orderDao.delOrder(order);
                    orderWasDeleted = true;
                }
            } catch (DataIntegrityException e) {
                // Just "mask" "specific user exception possibly generated by <orderDeletedState>"
            }

            if (!orderWasDeleted) {
                // Perhaps, to raise exception seems to be unnecessary and excessive, but let use such a "mechanism"!
                errorMessage(String.format(
                        IMPOSSIBLE_TO_DELETE_ORDER_PATTERN, order.getStateTypeName(), order.getOrderId()));
            }

        } catch (DataIntegrityException e) {
            result = e.getMessage();
        }

        return result;
    }

    public Order findOrderById(int id) {
        return orderDao.findOrderById(id);
    }

    public Order closeOrder(Order order) {
        return orderDao.updOrderState(order, orderClosedState(order));
    }

    public List<Order> findAllOrders(String stateType) {
        return orderDao.findAllOrders(stateType);
    }

    public List<Order> findAllOpenOrders() {
        return findAllOrders(orderCreationState());
    }

    public List<Order> findAllClosedOrders() {
        return findAllOrders(orderClosedState());
    }

    public String addCourseToOrder(Order order, Course course, int quantity) {
        String result = null;

        try {
            if (isFillingActionEnabled(order)) {
                orderCourseDao.addCourseToOrder(order, course, quantity);
            } else {
                // Perhaps, to raise exception seems to be unnecessary and excessive, but let use such a "mechanism"!
                errorMessage(String.format(
                        IMPOSSIBLE_TO_ADD_COURSE_TO_ORDER_PATTERN, order.getStateTypeName(), order.getOrderId()));
            }

        } catch (Exception e) {
            result = e.getMessage();
        }

        return result;
    }

    public String  addCourseToOrder(Order order, Course course) {
        return addCourseToOrder(order, course, 1);
    }

    public String takeCourseFromOrder(Order order, Course course, int quantity) {
        String result = null;

        try {
            if (isFillingActionEnabled(order)) {
                orderCourseDao.takeCourseFromOrder(order, course, quantity);
            } else {
                errorMessage(String.format(
                        IMPOSSIBLE_TO_DEL_COURSE_FROM_ORDER_PATTERN, order.getStateTypeName(), order.getOrderId()));
            }
        } catch (Exception e) {
            result = e.getMessage();
        }

        return result;
    }

    public String takeCourseFromOrder(Order order, Course course) {
        return takeCourseFromOrder(order, course, 1);
    }

    public List<OrderCourse> findAllOrderCourses(Order order) {
        return orderCourseDao.findAllOrderCourses(order);
    }

    public List<Order> findOrderByNumber(String orderNumber) {
        return orderDao.findOrderByNumber(orderNumber);
    }

    public OrderCourse findOrderCourseByCourseId(Order order, int courseId) {
        return orderCourseDao.findOrderCourseByCourseId(order, courseId);
    }
}
