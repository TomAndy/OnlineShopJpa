package com.mp.onlinestore.response;

public class CreateClientResponse extends GeneralResponse {
    private Long clientId;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public CreateClientResponse(String successMessage, Long clientId) {
        super(successMessage);
        this.clientId = clientId;
    }

    public CreateClientResponse(Long clientId) {
        this.clientId = clientId;
    }

    public CreateClientResponse() {}
}
