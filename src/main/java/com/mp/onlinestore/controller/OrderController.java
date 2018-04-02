package com.mp.onlinestore.controller;

import com.mp.onlinestore.converter.OrderConverter;
import com.mp.onlinestore.enums.OrderStatusEnum;
import com.mp.onlinestore.exceptions.GenericException;
import com.mp.onlinestore.exceptions.ValidationException;
import com.mp.onlinestore.model.Client;
import com.mp.onlinestore.model.Order;
import com.mp.onlinestore.request.CreateOrderRequest;
import com.mp.onlinestore.request.UpdateOrderRequest;
import com.mp.onlinestore.response.*;
import com.mp.onlinestore.service.ClientService;
import com.mp.onlinestore.service.OrderService;
import com.mp.onlinestore.util.CustomExceptionHandler;
import com.mp.onlinestore.validator.OrderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderValidator orderValidator;
    @Autowired
    private OrderConverter orderConverter;
    @Autowired
    private ClientService clientService;
    @Autowired
    private CustomExceptionHandler customExceptionHandler;

    @RequestMapping(value = "/order", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public CreateOrderResponse createOrder(@RequestBody final CreateOrderRequest createOrderRequest) throws GenericException {
        CreateOrderResponse createOrderResponse = null;
        try {
            orderValidator.validateCreateRequest(createOrderRequest);
            Client client = clientService.findById(createOrderRequest.getClientId());
            Order order = orderConverter.convertCreateRequestToOrder(createOrderRequest, client);
            Order orderCreated = orderService.createOrder(order);
            createOrderResponse = orderConverter.convertOrderToCreateOrderResponse(orderCreated);
        }catch (ValidationException ve) {
            customExceptionHandler.printValidationExceptions(ve);
            ve.printStackTrace();
        }catch (Exception e) {
            System.out.println("Server error");
            e.printStackTrace();
        }
        return createOrderResponse;
    }

    @RequestMapping(value = "/order/{orderId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public GetOrderResponse findById(@PathVariable("orderId") final Long orderId) throws GenericException {
        Order order = orderService.findById(orderId);
        GetOrderResponse getOrderResponse = orderConverter.convertOrderToGetOrderResponse(order);
        return getOrderResponse;
    }

    @RequestMapping(value = "/order", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public UpdateOrderResponse updateOrder(@RequestBody final UpdateOrderRequest updateOrderRequest) {
        UpdateOrderResponse updateOrderResponse = null;
        try {
            orderValidator.validateUpdateRequest(updateOrderRequest);
            Order order = orderConverter.convertUpdateRequestToOrder(updateOrderRequest);
            Order updatedOrder = orderService.updateOrder(order);
            updateOrderResponse = orderConverter.convertOrderToUpdateOrderResponse(updatedOrder);
        } catch (ValidationException ve) {
            customExceptionHandler.printValidationExceptions(ve);
            ve.printStackTrace();
        }catch (Exception e) {
            System.out.println("Server error");
            e.printStackTrace();
        }
        return updateOrderResponse;
    }

    @RequestMapping(value = "/order/{orderId}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public DeleteOrderResponse deleteOrder(@PathVariable("orderId") final Long orderId) throws GenericException {
        Order order = orderService.deleteOrder(orderId);
        DeleteOrderResponse deleteOrderResponse = orderConverter.convertOrderToDeleteOrderResponse(order);
        return deleteOrderResponse;
    }

    @RequestMapping(value = "/order/all", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public GetAllOrdersResponse findAll() throws GenericException {
        Collection<Order> listOfOrders = orderService.findAll();
        GetAllOrdersResponse getAllOrdersResponse = orderConverter.convertOrdersToGetAllOrdersResponse(listOfOrders);
        return getAllOrdersResponse;
    }

    @RequestMapping(value = "/order/status/{orderStatus}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Collection<Order> findByStatus(@PathVariable("orderStatus") final OrderStatusEnum orderStatus) throws GenericException {
        return orderService.findByStatus(orderStatus);
    }


}
