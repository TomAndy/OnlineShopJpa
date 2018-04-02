package com.mp.onlinestore.response;

import com.mp.onlinestore.model.Client;

import java.util.Collection;

public class GetAllClientsResponse {

    private Collection<Client> listOfClients;

    public Collection<Client> getListOfClients() {
        return listOfClients;
    }

    public void setListOfClients(Collection<Client> listOfClients) {
        this.listOfClients = listOfClients;
    }

    public GetAllClientsResponse(Collection<Client> listOfClients) {
        this.listOfClients = listOfClients;
    }

    public GetAllClientsResponse() {}
}
