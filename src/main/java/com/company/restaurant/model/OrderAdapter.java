package com.company.restaurant.model;

import java.util.List;

/**
 * Created by Yevhen on 22.05.2016.
 */
public class OrderAdapter {
    private OrderDao orderDao;
    private StateGraphRules stateGraphRules;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void setStateGraphRules(StateGraphRules stateGraphRules) {
        this.stateGraphRules = stateGraphRules;
    }

    public int addOrder(Order order) {
        order.setStateType(stateGraphRules.creationState(orderDao.orderEntityName()));

        return orderDao.addOrder(order);
    }

    public void delOrder(Order order) {
        orderDao.delOrder(order);
    }

    public Order findOrderById(int id) {
        return orderDao.findOrderById(id);
    }

    public List<Order> findAllOrders(String stateType) {
        return orderDao.findAllOrders(stateType);
    }

    public void closeOrder(Order order) {
        orderDao.updOrderState(order, stateGraphRules.closedState(orderDao.orderEntityName(), order.getStateType()));
    }
}
