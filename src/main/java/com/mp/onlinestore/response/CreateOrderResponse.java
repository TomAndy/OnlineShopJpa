package com.mp.onlinestore.response;

public class CreateOrderResponse extends GeneralResponse{

    private Long orderId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public CreateOrderResponse(Long orderId, String successMessage) {
        super(successMessage);
        this.orderId = orderId;
    }

    public CreateOrderResponse() {}
}
