package com.mp.onlinestore.response;

import com.mp.onlinestore.model.Order;

import java.util.Collection;

public class GetClientResponse {
    private Long clientId;
    private String clientLogin;
    private String clientName;
    private String clientEmail;
    private Collection<Order> orderList;

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

    public Collection<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(Collection<Order> orderList) {
        this.orderList = orderList;
    }

    public GetClientResponse(Long clientId, String clientLogin, String clientName, String clientEmail, Collection<Order> orderList) {
        this.clientId = clientId;
        this.clientLogin = clientLogin;
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.orderList = orderList;
    }

    public GetClientResponse() {}
}
