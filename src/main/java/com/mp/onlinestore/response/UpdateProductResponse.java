package com.mp.onlinestore.response;

public class UpdateProductResponse extends GeneralResponse {

    private Long productId;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public UpdateProductResponse(String successMessage, Long productId) {
        super(successMessage);
        this.productId = productId;
    }

    public UpdateProductResponse(Long productId) {
        this.productId = productId;
    }

    public UpdateProductResponse() {}
}
