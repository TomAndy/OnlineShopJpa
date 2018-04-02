package com.mp.onlinestore.request;

import com.mp.onlinestore.model.Product;

import java.util.List;

public class CreateOrderRequest {

    private Long clientId;
    private List<Product> productList;

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

    public CreateOrderRequest(Long clientId, List<Product> productList) {
        this.clientId = clientId;
        this.productList = productList;
    }

    public CreateOrderRequest() {}
}
