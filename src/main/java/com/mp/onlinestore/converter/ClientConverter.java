package com.mp.onlinestore.converter;

import com.mp.onlinestore.dto.ClientDto;
import com.mp.onlinestore.model.Client;
import com.mp.onlinestore.request.CreateClientRequest;
import com.mp.onlinestore.request.UpdateClientRequest;
import com.mp.onlinestore.response.*;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class ClientConverter {
    public ClientDto convertClientToClientDto(Client client) {
        ClientDto clientDto = new ClientDto();
        clientDto.setClientName(client.getClientName());
        clientDto.setClientLogin(client.getClientLogin());
        clientDto.setClientEmail(client.getClientEmail());
        return clientDto;
    }

    public Client convertClientDtoToClient(ClientDto clientDto) {
        Client client = new Client();
        client.setClientName(clientDto.getClientName());
        client.setClientLogin(clientDto.getClientLogin());
        client.setClientEmail(clientDto.getClientEmail());
        return client;
    }

    public Client convertCreateRequestToClient(CreateClientRequest createClientRequest) {
        Client client = new Client();
        client.setClientLogin(createClientRequest.getClientLogin());
        client.setClientName(createClientRequest.getClientName());
        client.setClientEmail(createClientRequest.getClientEmail());
        return client;
    }

    public CreateClientResponse convertClientToCreateClientResponse(Client client) {
        CreateClientResponse createClientResponse = new CreateClientResponse();
        if(client != null) {
            createClientResponse.setClientId(client.getClientId());
            createClientResponse.setSuccessMessage("Client was created");
        }
        else {
            createClientResponse.setSuccessMessage("Client was not created");
        }
        return createClientResponse;
    }

    public GetClientResponse convertClientToGetClientResponse(Client client) {
        GetClientResponse getClientResponse = new GetClientResponse();
        if (client != null) {
            getClientResponse.setClientId(client.getClientId());
            getClientResponse.setClientLogin(client.getClientLogin());
            getClientResponse.setClientName(client.getClientName());
            getClientResponse.setClientEmail(client.getClientEmail());
            getClientResponse.setOrderList(client.getOrderList());
        }
        return getClientResponse;
    }

    public Client convertUpdateClientRequestToClient(UpdateClientRequest updateClientRequest) {
        Client client = new Client();
        if(updateClientRequest != null) {
            client.setClientId(updateClientRequest.getClientId());
            client.setClientLogin(updateClientRequest.getClientLogin());
            client.setClientName(updateClientRequest.getClientName());
            client.setClientEmail(updateClientRequest.getClientEmail());
        }
        return client;
    }

    public UpdateClientResponse convertClientToUpdateClientResponse(Client client) {
        UpdateClientResponse updateClientResponse = new UpdateClientResponse();
        if(client != null) {
            updateClientResponse.setClientId(client.getClientId());
            updateClientResponse.setSuccessMessage("Client was updated");
        }
        else {
            updateClientResponse.setSuccessMessage("Client was not updated");
        }
        return updateClientResponse;
    }

    public DeleteClientResponse convertClientToDeleteClientResponse(Client client) {
        DeleteClientResponse deleteClientResponse = new DeleteClientResponse();
        if(client != null) {
            deleteClientResponse.setClientId(client.getClientId());
            deleteClientResponse.setSuccessMessage("Client was deleted");
        }
        else {
            deleteClientResponse.setSuccessMessage("Client was not deleted");
        }
        return deleteClientResponse;
    }

    public GetAllClientsResponse convertClientsToGetAllClientsResponse(Collection<Client> listOfClients) {
        GetAllClientsResponse getAllClientsResponse = new GetAllClientsResponse();
        if(listOfClients.size() !=0) {
            getAllClientsResponse.setListOfClients(listOfClients);
        }
        return getAllClientsResponse;
    }

}
