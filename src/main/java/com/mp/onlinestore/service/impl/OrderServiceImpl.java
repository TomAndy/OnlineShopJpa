package com.mp.onlinestore.service.impl;

import com.mp.onlinestore.dao.OrderDao;
import com.mp.onlinestore.enums.OrderStatusEnum;
import com.mp.onlinestore.exceptions.GenericException;
import com.mp.onlinestore.model.Order;
import com.mp.onlinestore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.logging.Logger;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    @Qualifier("OrderDaoImplJpa")
    private OrderDao orderDao;

    static Logger log = Logger.getLogger(ClientServiceImpl.class.toString());

    @Override
    public Order createOrder(Order order) throws GenericException {
        log.info("Starting to create order: " + order);

        Order orderCreated = orderDao.createOrder(order);

        log.info("Finishing to create order. Order created");
        return orderCreated;
    }

    @Override
    public Order findById(Long orderID) throws GenericException {
        log.info("Starting to read order by ID: " + orderID);

        Order order = orderDao.findById(orderID);

        log.info("Finishing to read order. Order data: " + order);
        return order;
    }

    @Override
    public Order updateOrder(Order order) throws GenericException {
        log.info("Starting to update order with new attributes: " + order);

        Order updatedOrder = orderDao.updateOrder(order);

        log.info("Finishing to update order. Order updated: " + updatedOrder);
        return updatedOrder;
    }

    @Override
    public Order deleteOrder(Long orderId) throws GenericException {
        log.info("Starting to delete order with ID: " + orderId);

        Order order = orderDao.deleteOrder(orderId);

        log.info("Finishing to delete order. Order deleted: " + order);
        return order;
    }

    @Override
    public Collection<Order> findAll() throws GenericException {
        log.info("Start to read all orders from DB");

        Collection<Order> orderList = orderDao.findAll();

        log.info("Finish to read all orders from DB");

        return orderList;
    }

    @Override
    public Collection<Order> findByStatus(OrderStatusEnum orderStatus) throws GenericException {
        log.info("Starting to read orders by status: " + orderStatus);

        Collection<Order> orderList = orderDao.findByStatus(orderStatus);

        log.info("Finishing to read orders from DB");
        return orderList;
    }
}
