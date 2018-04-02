package com.mp.onlinestore.response;

public class DeleteOrderResponse extends GeneralResponse {
    private Long orderId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public DeleteOrderResponse(String successMessage, Long orderId) {
        super(successMessage);
        this.orderId = orderId;
    }

    public DeleteOrderResponse(Long orderId) {
        this.orderId = orderId;
    }

    public DeleteOrderResponse() {}
}
