package com.mp.onlinestore.dao;

import com.mp.onlinestore.enums.OrderStatusEnum;
import com.mp.onlinestore.exceptions.GenericException;
import com.mp.onlinestore.model.Order;

import java.util.Collection;

public interface OrderDao {
    Order createOrder(final Order order) throws GenericException;

    Order findById(final Long orderId) throws GenericException;

    Order updateOrder(final Order order) throws GenericException;

    Order deleteOrder(final Long orderId) throws GenericException;

    public Collection<Order> findAll() throws GenericException;

    public Collection<Order> findByStatus(OrderStatusEnum orderStatus) throws GenericException;
}
