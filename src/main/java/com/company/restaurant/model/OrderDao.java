package com.company.restaurant.model;

import java.util.List;

/**
 * Created by Yevhen on 22.05.2016.
 */
public interface OrderDao {
    String orderEntityName();

    Order addOrder(Order order);

    String delOrder(Order order);

    Order findOrderById(int id);

    List<Order> findOrderByNumber(String orderNumber);

    List<Order> findAllOrders(String stateType);

    Order updOrderState(Order order, String stateType);
}
