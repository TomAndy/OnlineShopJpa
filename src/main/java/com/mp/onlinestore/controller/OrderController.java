package com.mp.onlinestore.controller;

import com.mp.onlinestore.Exceptions.GenericException;
import com.mp.onlinestore.model.Order;
import com.mp.onlinestore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/order", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public boolean createOrder(@RequestBody final Order order) throws GenericException {
        return orderService.createOrder(order);
    }

    @RequestMapping(value = "/order/{orderId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Order findById(@PathVariable("orderId") final Long orderId) throws GenericException {
        return orderService.findById(orderId);
    }

    @RequestMapping(value = "/order", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public boolean updateOrder(@RequestBody final Order order) throws GenericException {
        return orderService.updateOrder(order);
    }

    @RequestMapping(value = "/order/{orderId}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public boolean deleteOrder(@PathVariable("orderId") final Long orderId) throws GenericException {
        return orderService.deleteOrder(orderId);
    }

    @RequestMapping(value = "/order/all", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Collection<Order> findAll() throws GenericException {
        return orderService.findAll();
    }


}
