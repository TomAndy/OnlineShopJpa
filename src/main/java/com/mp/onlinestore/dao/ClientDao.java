package com.mp.onlinestore.dao;

import com.mp.onlinestore.exceptions.GenericException;
import com.mp.onlinestore.model.Client;

import java.util.Collection;

public interface ClientDao {

	Client createClient(final Client client) throws GenericException;

	Client findById(final Long clientId) throws GenericException;

	Client updateClient(final Client client) throws GenericException;

	Client deleteClient(final Long clientId) throws GenericException;

	public Collection<Client> findAll() throws GenericException;
}
