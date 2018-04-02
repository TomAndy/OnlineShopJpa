package com.mp.onlinestore.response;

public class CreateProductResponse extends GeneralResponse {

    private Long productId;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public CreateProductResponse(String successMessage, Long productId) {
        super(successMessage);
        this.productId = productId;
    }

    public CreateProductResponse(Long productId) {
        this.productId = productId;
    }

    public CreateProductResponse() {}
}
