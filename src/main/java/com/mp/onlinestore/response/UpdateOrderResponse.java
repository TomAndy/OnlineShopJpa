package com.mp.onlinestore.response;

public class UpdateOrderResponse extends GeneralResponse{

    private Long orderId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public UpdateOrderResponse(String successMessage, Long orderId) {
        super(successMessage);
        this.orderId = orderId;
    }

    public UpdateOrderResponse() {}
}
