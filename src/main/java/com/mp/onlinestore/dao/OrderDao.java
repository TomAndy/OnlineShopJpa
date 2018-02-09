package com.mp.onlinestore.dao;

import com.mp.onlinestore.Exceptions.GenericException;
import com.mp.onlinestore.model.Order;

import java.util.Collection;

public interface OrderDao {
    boolean createOrder(final Order order) throws GenericException;

    Order findById(final Long orderId) throws GenericException;

    boolean updateOrder(final Order order) throws GenericException;

    boolean deleteOrder(final Long orderId) throws GenericException;

    public Collection<Order> findAll() throws GenericException;
}
