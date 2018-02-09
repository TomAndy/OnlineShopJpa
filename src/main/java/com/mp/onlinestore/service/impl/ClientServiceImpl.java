package com.mp.onlinestore.service.impl;

import com.mp.onlinestore.Exceptions.GenericException;
import com.mp.onlinestore.dao.ClientDao;
import com.mp.onlinestore.model.Client;
import com.mp.onlinestore.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.logging.Logger;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
//	@Qualifier("ClientDaoImpl")
	@Qualifier("ClientDaoImplJpa")
	private ClientDao clientDao;

	static Logger log = Logger.getLogger(ClientServiceImpl.class.toString());

	@Override
	public boolean createClient(final Client client) throws GenericException{
		log.info("Starting to create client: " + client);

		boolean isCreated = clientDao.createClient(client);

		log.info("Finishing to create client. Client created: " + isCreated);
		return isCreated;
	}

	@Override
	public Client findById(final Long clientId) throws GenericException {
		log.info("Starting to read client by ID: " + clientId);

		Client client = clientDao.findById(clientId);

		log.info("Finishing to read client. Client data: " + client);
		return client;
	}

	@Override
	public boolean updateClient(final Client client) throws GenericException {
		log.info("Starting to update client with new attributes: " + client);

		boolean isUpdated = clientDao.updateClient(client);

		log.info("Finishing to update client. Client updated: " + isUpdated);
		return isUpdated;
	}

	@Override
	public boolean deleteClient(final Long clientId) throws GenericException {
		log.info("Starting to delete client with ID: " + clientId);

		boolean isDeleted = clientDao.deleteClient(clientId);

		log.info("Finishing to delete client. Client deleted: " + isDeleted);
		return isDeleted;
	}

	@Override
	public Collection<Client> findAll() throws GenericException {
		log.info("Start to read all clients from DB");

		Collection<Client> clientList = clientDao.findAll();

		log.info("Finish to read all clients from DB" + clientList);
		return clientList;
	}
}
