package com.mp.onlinestore.controller;

import com.mp.onlinestore.converter.ClientConverter;
import com.mp.onlinestore.exceptions.GenericException;
import com.mp.onlinestore.exceptions.ValidationException;
import com.mp.onlinestore.model.Client;
import com.mp.onlinestore.request.CreateClientRequest;
import com.mp.onlinestore.request.UpdateClientRequest;
import com.mp.onlinestore.response.*;
import com.mp.onlinestore.service.ClientService;
import com.mp.onlinestore.util.CustomExceptionHandler;
import com.mp.onlinestore.validator.ClientValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ClientController {

	@Autowired
	private ClientService clientService;
	@Autowired
	private ClientValidator clientValidator;
	@Autowired
	private ClientConverter clientConverter;
	@Autowired
	private CustomExceptionHandler customExceptionHandler;


	@RequestMapping(value = "/client", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public CreateClientResponse createClient(@RequestBody final CreateClientRequest createClientRequest) {
		CreateClientResponse createClientResponse = null;
		try {
			clientValidator.validateCreateRequest(createClientRequest);
			Client client = clientConverter.convertCreateRequestToClient(createClientRequest);
			Client clientCreated = clientService.createClient(client);
			createClientResponse = clientConverter.convertClientToCreateClientResponse(clientCreated);
		} catch (ValidationException ve) {
			customExceptionHandler.printValidationExceptions(ve);
			ve.printStackTrace();
		} catch (Exception e) {
			System.out.println("Server error");
			e.printStackTrace();
		}
		return createClientResponse;
	}

	@RequestMapping(value = "/client/{clientId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public GetClientResponse findById(@PathVariable("clientId") final Long clientId) throws GenericException {
		GetClientResponse getClientResponse = null;
		Client client = clientService.findById(clientId);
		getClientResponse = clientConverter.convertClientToGetClientResponse(client);
		return getClientResponse;
	}

	@RequestMapping(value = "/client", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public UpdateClientResponse updateClient(@RequestBody final UpdateClientRequest updateClientRequest) throws GenericException {
		UpdateClientResponse updateClientResponse = null;
		try {
			clientValidator.validateUpdateRequest(updateClientRequest);
			Client client = clientConverter.convertUpdateClientRequestToClient(updateClientRequest);
			Client clientUpdated = clientService.updateClient(client);
			updateClientResponse = clientConverter.convertClientToUpdateClientResponse(clientUpdated);
		} catch(ValidationException ve) {
			customExceptionHandler.printValidationExceptions(ve);
			ve.printStackTrace();
		} catch (Exception e) {
			System.out.println("Server error");
			e.printStackTrace();
		}
		return updateClientResponse;
	}

	@RequestMapping(value = "/client/{clientId}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
	public DeleteClientResponse deleteClient(@PathVariable("clientId") final Long clientId) throws GenericException {
		Client client = clientService.deleteClient(clientId);
		DeleteClientResponse deleteClientResponse = clientConverter.convertClientToDeleteClientResponse(client);
		return deleteClientResponse;
	}

	@RequestMapping(value = "/client/all", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public GetAllClientsResponse findAll() throws GenericException {
		Collection<Client> listOfClients = clientService.findAll();
		GetAllClientsResponse getAllClientResponses = clientConverter.convertClientsToGetAllClientsResponse(listOfClients);
		return getAllClientResponses;
	}
}
