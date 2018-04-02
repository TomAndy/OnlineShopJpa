package com.mp.onlinestore.validator;

import com.mp.onlinestore.consts.ErrorCodes;
import com.mp.onlinestore.exceptions.GenericException;
import com.mp.onlinestore.exceptions.ValidationException;
import com.mp.onlinestore.request.CreateOrderRequest;
import com.mp.onlinestore.request.UpdateOrderRequest;
import com.mp.onlinestore.service.ClientService;
import com.mp.onlinestore.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class OrderValidator {

    @Autowired
    private ClientService clientService;

    public void validateCreateRequest(CreateOrderRequest createOrderRequest) throws ValidationException, GenericException {
        Set<String> errorCodes = new HashSet<>();
        if (StringUtils.isNullOrZero(createOrderRequest.getClientId())) {
            errorCodes.add(ErrorCodes.INVALID_CLIENT);
        }
        if (StringUtils.isNullOrEmpty(createOrderRequest.getProductList())) {
            errorCodes.add(ErrorCodes.NO_PRODUCTS_IN_ORDER);
        }
        if (clientService.findById(createOrderRequest.getClientId()) == null) {
            errorCodes.add(ErrorCodes.NO_CLIENT_IN_DB);
        }
        if (!errorCodes.isEmpty()) {
            throw new ValidationException(errorCodes);
        }
    }

    public void validateUpdateRequest(UpdateOrderRequest updateOrderRequest) throws ValidationException {
        Set<String> errorCodes = new HashSet<>();
        if (StringUtils.isNullOrZero(updateOrderRequest.getOrderId())) {
            errorCodes.add(ErrorCodes.ORDER_DTO_ERR);
        }
        if (!errorCodes.isEmpty()) {
            throw new ValidationException(errorCodes);
        }
    }

}
