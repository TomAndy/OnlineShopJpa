package com.mp.onlinestore.dao;

import com.mp.onlinestore.Exceptions.GenericException;
import com.mp.onlinestore.model.Client;

import java.util.Collection;

public interface ClientDao {

	boolean createClient(final Client client) throws GenericException;

	Client findById(final Long clientId) throws GenericException;

	boolean updateClient(final Client client) throws GenericException;

	boolean deleteClient(final Long clientId) throws GenericException;

	public Collection<Client> findAll() throws GenericException;

}
