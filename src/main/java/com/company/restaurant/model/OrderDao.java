package com.company.restaurant.model;

import org.aspectj.weaver.ast.Or;

import java.util.List;

/**
 * Created by Yevhen on 22.05.2016.
 */
public interface OrderDao {
    String orderEntityName();

    int addOrder(Order order);

    void delOrder(Order order);

    Order findOrderById(int id);

    List<Order> findAllOrders(String stateType);

    void updOrderState(Order order, String stateType);
}
