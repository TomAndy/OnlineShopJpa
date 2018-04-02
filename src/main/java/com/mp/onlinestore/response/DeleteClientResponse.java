package com.mp.onlinestore.response;

public class DeleteClientResponse extends GeneralResponse{

    private Long clientId;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public DeleteClientResponse(String successMessage, Long clientId) {
        super(successMessage);
        this.clientId = clientId;
    }

    public DeleteClientResponse(Long clientId) {
        this.clientId = clientId;
    }

    public DeleteClientResponse() {}
}
