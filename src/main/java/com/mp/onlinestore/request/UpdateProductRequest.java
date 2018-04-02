package com.mp.onlinestore.request;

public class UpdateProductRequest {

    private Long productId;
    private String productName;
    private double productPrice;
    private String productColor;

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

    public UpdateProductRequest(Long productId, String productName, double productPrice, String productColor) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productColor = productColor;
    }

    public UpdateProductRequest() {}
}
