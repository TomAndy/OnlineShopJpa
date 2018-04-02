package com.mp.onlinestore.dto;

import com.mp.onlinestore.enums.OrderStatusEnum;
import com.mp.onlinestore.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDto {

    private Long orderId;
    private OrderStatusEnum orderStatus;
    private Long clientId;
    private List<Product> productList;

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

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public OrderDto(Long orderId, OrderStatusEnum orderStatus, Long clientId, List<Product> productList) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.clientId = clientId;
        this.productList = productList;
    }

    public OrderDto(Long orderId, OrderStatusEnum orderStatus, List<Product> productList) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.productList = productList;
    }

    public OrderDto() {}

    public String toString() {
        final StringBuilder sb = new StringBuilder("OrderDto{ ");
        sb.append("clientId= ").append(clientId);
        sb.append(", productList= ").append(productList).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
