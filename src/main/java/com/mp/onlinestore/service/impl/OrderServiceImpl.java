package com.mp.onlinestore.service.impl;

import com.mp.onlinestore.Exceptions.GenericException;
import com.mp.onlinestore.dao.OrderDao;
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
    public boolean createOrder(Order order) throws GenericException {
        log.info("Starting to create order: " + order);

        boolean isCreated = orderDao.createOrder(order);

        log.info("Finishing to create order. Order created: " + isCreated);
        return isCreated;
    }

    @Override
    public Order findById(Long orderID) throws GenericException {
        log.info("Starting to read order by ID: " + orderID);

        Order order = orderDao.findById(orderID);

        log.info("Finishing to read order. Order data: " + order);
        return order;
    }

    @Override
    public boolean updateOrder(Order order) throws GenericException {
        log.info("Starting to update order with new attributes: " + order);

        boolean isUpdated = orderDao.updateOrder(order);

        log.info("Finishing to update order. Order updated: " + isUpdated);
        return isUpdated;
    }

    @Override
    public boolean deleteOrder(Long orderId) throws GenericException {
        log.info("Starting to delete order with ID: " + orderId);

        boolean isDeleted = orderDao.deleteOrder(orderId);

        log.info("Finishing to delete order. Order deleted: " + isDeleted);
        return isDeleted;
    }

    @Override
    public Collection<Order> findAll() throws GenericException {
        log.info("Start to read all orders from DB");

        Collection<Order> orderList = orderDao.findAll();

        log.info("Finish to read all orders from DB");

        return orderList;
    }
}
