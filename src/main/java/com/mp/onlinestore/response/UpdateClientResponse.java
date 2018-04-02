package com.mp.onlinestore.response;

public class UpdateClientResponse extends GeneralResponse {

    private Long clientId;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public UpdateClientResponse(String successMessage, Long clientId) {
        super(successMessage);
        this.clientId = clientId;
    }

    public UpdateClientResponse(Long clientId) {
        this.clientId = clientId;
    }

    public UpdateClientResponse() {}
}
