package com.mp.onlinestore.validator;

import com.mp.onlinestore.consts.ErrorCodes;
import com.mp.onlinestore.dto.ClientDto;
import com.mp.onlinestore.exceptions.GenericException;
import com.mp.onlinestore.exceptions.ValidationException;
import com.mp.onlinestore.request.CreateClientRequest;
import com.mp.onlinestore.request.UpdateClientRequest;
import com.mp.onlinestore.util.StringUtils;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ClientValidator {

    public void validate(ClientDto clientDto) throws GenericException {
        if(clientDto.getClientName().equals("") || !(clientDto.getClientName() instanceof String))
        {
            throw new GenericException(ErrorCodes.INVALID_CLIENT);
        }
        if(clientDto.getClientLogin().equals("")|| !(clientDto.getClientLogin() instanceof String))
        {
            throw new GenericException(ErrorCodes.INVALID_CLIENT);
        }
        if(clientDto.getClientEmail().equals("") || !(clientDto.getClientEmail() instanceof String))
        {
            throw new GenericException(ErrorCodes.INVALID_CLIENT);
        }
    }

    public void validateCreateRequest(CreateClientRequest createClientRequest) throws ValidationException {

        Set<String> errorCodes = new HashSet<>();
        if(StringUtils.isNullOrEmpty(createClientRequest.getClientLogin())) {
            errorCodes.add(ErrorCodes.INVALID_CLIENT);
        }
        if(StringUtils.isNullOrEmpty(createClientRequest.getClientName())) {
            errorCodes.add(ErrorCodes.CLIENT_NAME_NOT_SPECIFIED);
        }
        if(!errorCodes.isEmpty()) {
            throw new ValidationException(errorCodes);
        }
    }

    public void validateUpdateRequest(UpdateClientRequest updateClientRequest) throws ValidationException {

        Set<String> errorCodes = new HashSet<>();
        if(StringUtils.isNullOrZero(updateClientRequest.getClientId())) {
            errorCodes.add(ErrorCodes.INVALID_CLIENT);
        }
        if(StringUtils.isNullOrEmpty(updateClientRequest.getClientLogin())) {
            errorCodes.add(ErrorCodes.CLIENT_LOGIN_NOT_SPECIFIED);
        }
        if(StringUtils.isNullOrEmpty(updateClientRequest.getClientName())) {
            errorCodes.add(ErrorCodes.CLIENT_NAME_NOT_SPECIFIED);
        }
        if(!errorCodes.isEmpty()) {
            throw new ValidationException(errorCodes);
        }
    }
}
