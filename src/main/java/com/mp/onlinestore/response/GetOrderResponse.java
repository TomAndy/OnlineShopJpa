package com.mp.onlinestore.response;

import com.mp.onlinestore.enums.OrderStatusEnum;
import com.mp.onlinestore.model.Client;
import com.mp.onlinestore.model.Product;

import java.util.Collection;

public class GetOrderResponse {
    private Long orderId;
    private OrderStatusEnum orderStatus;
    private Client client;
    private Collection<Product> productList;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public OrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Collection<Product> getProductList() {
        return productList;
    }

    public void setProductList(Collection<Product> productList) {
        this.productList = productList;
    }

    public GetOrderResponse(Long orderId, OrderStatusEnum orderStatus, Client client, Collection<Product> productList) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.client = client;
        this.productList = productList;
    }

    public GetOrderResponse () {}
}
