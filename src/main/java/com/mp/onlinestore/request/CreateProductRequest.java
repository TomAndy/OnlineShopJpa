package com.mp.onlinestore.request;

import com.mp.onlinestore.model.Category;

public class CreateProductRequest {

    private String productName;
    private double productPrice;
    private String productColor;
    private Category category;

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

    public CreateProductRequest(String productName, double productPrice, String productColor, Category category) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productColor = productColor;
        this.category = category;
    }

    public CreateProductRequest() {}
}
