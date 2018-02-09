package com.mp.onlinestore.service;

import com.mp.onlinestore.Exceptions.GenericException;
import com.mp.onlinestore.model.Order;

import java.util.Collection;

public interface OrderService {

    boolean createOrder(final Order order) throws GenericException;

    public Order findById(final Long orderID) throws GenericException;

    boolean updateOrder(final Order order) throws GenericException;

    boolean deleteOrder(final Long orderId) throws GenericException;

    public Collection<Order> findAll() throws GenericException;
}
