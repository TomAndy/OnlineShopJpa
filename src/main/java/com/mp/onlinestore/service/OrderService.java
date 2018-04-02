package com.mp.onlinestore.service;

import com.mp.onlinestore.enums.OrderStatusEnum;
import com.mp.onlinestore.exceptions.GenericException;
import com.mp.onlinestore.model.Order;

import java.util.Collection;

public interface OrderService {

    public Order createOrder(final Order order) throws GenericException;

    public Order findById(final Long orderID) throws GenericException;

    public Order updateOrder(final Order order) throws GenericException;

    Order deleteOrder(final Long orderId) throws GenericException;

    public Collection<Order> findAll() throws GenericException;

    public Collection<Order> findByStatus(OrderStatusEnum orderStatus) throws GenericException;
}
