package com.mp.onlinestore.request;

public class UpdateClientRequest {

    private Long clientId;
    private String clientLogin;
    private String clientName;
    private String clientEmail;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getClientLogin() {
        return clientLogin;
    }

    public void setClientLogin(String clientLogin) {
        this.clientLogin = clientLogin;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public UpdateClientRequest(Long clientId, String clientLogin, String clientName, String clientEmail) {
        this.clientId = clientId;
        this.clientLogin = clientLogin;
        this.clientName = clientName;
        this.clientEmail = clientEmail;
    }

    public UpdateClientRequest() {}
}
