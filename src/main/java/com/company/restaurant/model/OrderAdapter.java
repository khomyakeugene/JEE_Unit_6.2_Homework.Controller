package com.company.restaurant.model;

import com.company.util.DataIntegrityException;

import java.util.List;

/**
 * Created by Yevhen on 22.05.2016.
 */
public class OrderAdapter {
    private static final String IMPOSSIBLE_TO_DELETE_ORDER_PATTERN =
            "It is impossible to delete order in <%s> state (<order_id> = %d)!";

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

    public int addOrder(Order order) {
        order.setStateType(orderCreationState());

        return orderDao.addOrder(order);
    }

    public void delOrder(Order order) {
        boolean orderWasDeleted = false;
        try {
            // Check if it is possible to delete (if <deleted state> is presented for this order)
            if (orderDeletedState(order) != null) {
                orderDao.delOrder(order);
                orderWasDeleted = true;
            }
        } catch (DataIntegrityException e) {
            // Just "mask" "specific user exception possibly generated by <orderDeletedState>"
        }

        if (!orderWasDeleted) {
            throw new DataIntegrityException(String.format(
                    IMPOSSIBLE_TO_DELETE_ORDER_PATTERN, order.getStateTypeName(), order.getOrderId()));
        }
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

    public void addCourseToOrder(Order order, Course course, int quantity) {
        orderCourseDao.addCourseToOrder(order, course, quantity);
    }

    public void delCourseFromOrder(Order order, Course course) {
        orderCourseDao.delCourseFromOrder(order, course);
    }
}
