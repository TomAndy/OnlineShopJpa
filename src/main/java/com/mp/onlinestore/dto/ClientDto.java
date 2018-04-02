package com.mp.onlinestore.dto;

import org.springframework.stereotype.Component;

@Component
public class ClientDto {
    private String clientLogin;
    private String clientName;
    private String clientEmail;

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

    public ClientDto(String clientLogin, String clientName, String clientEmail) {
        this.clientLogin = clientLogin;
        this.clientName = clientName;
        this.clientEmail = clientEmail;
    }

    public ClientDto() {}

    public String toString() {
        final StringBuilder sb = new StringBuilder("ClientDto{ ");
        sb.append("clientLogin= ").append(clientLogin);
        sb.append(", clientName= ").append(clientName).append('\'');
        sb.append(", clientEmail= ").append(clientEmail).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
