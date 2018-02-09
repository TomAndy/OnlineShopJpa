package com.mp.onlinestore.controller;

import com.mp.onlinestore.Exceptions.GenericException;
import com.mp.onlinestore.model.Client;
import com.mp.onlinestore.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ClientController {

	@Autowired
	private ClientService clientService;

	@RequestMapping(value = "/client", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public boolean createClient(@RequestBody final Client client) throws GenericException{
		return clientService.createClient(client);
	}

	@RequestMapping(value = "/client/{clientId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public Client findById(@PathVariable("clientId") final Long clientId) throws GenericException {
		return clientService.findById(clientId);
	}

	@RequestMapping(value = "/client", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public boolean updateClient(@RequestBody final Client client) throws GenericException {
		return clientService.updateClient(client);
	}

	@RequestMapping(value = "/client/{clientId}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
	public boolean deleteClient(@PathVariable("clientId") final Long clientId) throws GenericException {
		return clientService.deleteClient(clientId);
	}

	@RequestMapping(value = "/client/all", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public Collection<Client> findAll() throws GenericException {
		return clientService.findAll();
	}
}
