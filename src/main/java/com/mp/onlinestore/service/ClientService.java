package com.mp.onlinestore.service;

import com.mp.onlinestore.exceptions.GenericException;
import com.mp.onlinestore.model.Client;

import java.util.Collection;

public interface ClientService {

	Client createClient(final Client client) throws GenericException;

	public Client findById(final Long clientID) throws GenericException;

	Client updateClient(final Client client) throws GenericException;

	Client deleteClient(final Long clientId) throws GenericException;

	public Collection<Client> findAll() throws GenericException;

}
