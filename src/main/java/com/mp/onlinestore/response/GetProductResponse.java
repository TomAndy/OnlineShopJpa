package com.mp.onlinestore.response;

import com.mp.onlinestore.model.Category;
import com.mp.onlinestore.model.Order;

import java.util.Collection;

public class GetProductResponse {

    private Long productId;
    private String productName;
    private double productPrice;
    private String productColor;
    private Category category;
    private Collection<Order> orderList;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Collection<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(Collection<Order> orderList) {
        this.orderList = orderList;
    }

    public GetProductResponse(Long productId, String productName, double productPrice, String productColor, Category category, Collection<Order> orderList) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productColor = productColor;
        this.category = category;
        this.orderList = orderList;
    }

    public GetProductResponse() {}
}
