package com.mp.onlinestore.service;

import com.mp.onlinestore.Exceptions.GenericException;
import com.mp.onlinestore.model.Client;

import java.util.Collection;

public interface ClientService {

	boolean createClient(final Client client) throws GenericException;

	public Client findById(final Long clientID) throws GenericException;

	boolean updateClient(final Client client) throws GenericException;

	boolean deleteClient(final Long clientId) throws GenericException;

	public Collection<Client> findAll() throws GenericException;

}
