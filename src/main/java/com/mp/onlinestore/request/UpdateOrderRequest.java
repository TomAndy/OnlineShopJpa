package com.mp.onlinestore.request;

import com.mp.onlinestore.model.Product;

import java.util.List;

public class UpdateOrderRequest {

    private Long orderId;
    private List<Product> productList;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public UpdateOrderRequest(Long orderId, List<Product> productList) {
        this.orderId = orderId;
        this.productList = productList;
    }

    public UpdateOrderRequest() {}
}
