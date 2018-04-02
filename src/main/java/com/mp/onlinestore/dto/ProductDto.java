package com.mp.onlinestore.dto;

import org.springframework.stereotype.Component;

@Component
public class ProductDto {

    private Long productId;
    private String productName;
    private double productPrice;
    private String productColor;
    private Long categoryId;

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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public ProductDto(Long productId, String productName, double productPrice, String productColor, Long categoryId) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productColor = productColor;
        this.categoryId = categoryId;
    }

    public ProductDto() {}

    @Override
    public String toString() {
        return "ProductDto{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productColor='" + productColor + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }
}
