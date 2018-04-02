package com.mp.onlinestore.response;

public class DeleteProductResponse extends GeneralResponse{

    private Long productId;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public DeleteProductResponse(String successMessage, Long productId) {
        super(successMessage);
        this.productId = productId;
    }

    public DeleteProductResponse(Long productId) {
        this.productId = productId;
    }

    public DeleteProductResponse() {}
}
