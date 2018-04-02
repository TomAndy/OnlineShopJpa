package com.mp.onlinestore.converter;

import com.mp.onlinestore.dto.OrderDto;
import com.mp.onlinestore.exceptions.GenericException;
import com.mp.onlinestore.model.Client;
import com.mp.onlinestore.model.Order;
import com.mp.onlinestore.request.CreateOrderRequest;
import com.mp.onlinestore.request.UpdateOrderRequest;
import com.mp.onlinestore.response.*;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class OrderConverter {

    public OrderDto convertOrderToOrderDto(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderId(order.getOrderId());
        orderDto.setOrderStatus(order.getOrderStatus());
        orderDto.setClientId(order.getClient().getClientId());
        orderDto.setProductList((List)order.getProductList());
        return orderDto;
    }

    public Order convertCreateRequestToOrder(CreateOrderRequest createOrderRequest, Client client) throws GenericException{
        Order order = new Order();
        order.setClient(client);
        order.setProductList(createOrderRequest.getProductList());
        return order;
    }

    public GetOrderResponse convertOrderToGetOrderResponse(Order order) {
        GetOrderResponse getOrderResponse = new GetOrderResponse();
        if(order!= null) {
            getOrderResponse.setOrderId(order.getOrderId());
            getOrderResponse.setOrderStatus(order.getOrderStatus());
            getOrderResponse.setClient(order.getClient());
            getOrderResponse.setProductList(order.getProductList());
        }
        return getOrderResponse;
    }

    public CreateOrderResponse convertOrderToCreateOrderResponse(Order order) {
        CreateOrderResponse createOrderResponse = new CreateOrderResponse();
        if(order != null) {
            createOrderResponse.setOrderId(order.getOrderId());
            createOrderResponse.setSuccessMessage("Order created");
        }
        else {
            createOrderResponse.setSuccessMessage("Order was not created");
        }
        return createOrderResponse;
    }

    public UpdateOrderResponse convertOrderToUpdateOrderResponse(Order order) {
        UpdateOrderResponse updateOrderResponse = new UpdateOrderResponse();
        if(order != null) {
            updateOrderResponse.setOrderId(order.getOrderId());
            updateOrderResponse.setSuccessMessage("Order was updated");
            return updateOrderResponse;
        }
        else {
            updateOrderResponse.setSuccessMessage("Order was not updated");
            return updateOrderResponse;
        }
    }

    public Order convertUpdateRequestToOrder(UpdateOrderRequest updateOrderRequest) {
        Order order = new Order();
        order.setOrderId(updateOrderRequest.getOrderId());
        order.setProductList(updateOrderRequest.getProductList());
        return order;
    }

    public DeleteOrderResponse convertOrderToDeleteOrderResponse(Order order) {
        DeleteOrderResponse deleteOrderResponse = new DeleteOrderResponse();
        if(order != null) {
            deleteOrderResponse.setOrderId(order.getOrderId());
            deleteOrderResponse.setSuccessMessage("Order deleted");
        }
        else {
            deleteOrderResponse.setSuccessMessage("Order was not deleted");
        }
        return deleteOrderResponse;
    }

    public GetAllOrdersResponse convertOrdersToGetAllOrdersResponse(Collection<Order> listOfOrders) {
        GetAllOrdersResponse getAllOrdersResponse = new GetAllOrdersResponse();
        if(listOfOrders.size() !=0) {
            getAllOrdersResponse.setListOfOrders(listOfOrders);
        }
        return getAllOrdersResponse;
    }
}
