package com.mp.onlinestore.response;

import com.mp.onlinestore.model.Order;

import java.util.Collection;

public class GetAllOrdersResponse {

    private Collection<Order> listOfOrders;

    public Collection<Order> getListOfOrders() {
        return listOfOrders;
    }

    public void setListOfOrders(Collection<Order> listOfOrders) {
        this.listOfOrders = listOfOrders;
    }

    public GetAllOrdersResponse(Collection<Order> listOfOrders) {
        this.listOfOrders = listOfOrders;
    }

    public GetAllOrdersResponse() {}
}
