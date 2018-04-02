package com.mp.onlinestore.validator;

import com.mp.onlinestore.consts.ErrorCodes;
import com.mp.onlinestore.exceptions.ValidationException;
import com.mp.onlinestore.request.CreateProductRequest;
import com.mp.onlinestore.request.UpdateProductRequest;
import com.mp.onlinestore.util.StringUtils;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ProductValidator {

    public void validateCreateProductRequest(CreateProductRequest createProductRequest) throws ValidationException {
        Set<String> errorCodes = new HashSet<>();
        if(StringUtils.isNullOrEmpty(createProductRequest.getProductName())) {
            errorCodes.add(ErrorCodes.INVALID_PRODUCT_NAME);
        }
        if(StringUtils.isNullOrEmpty(createProductRequest.getProductColor())) {
            errorCodes.add(ErrorCodes.INVALID_PRODUCT_COLOR);
        }
        if(StringUtils.isNullOrZero(createProductRequest.getProductPrice())) {
            errorCodes.add(ErrorCodes.INVALID_PRODUCT_PRICE);
        }
        if(!errorCodes.isEmpty()) {
            throw new ValidationException(errorCodes);
        }
    }

    public void validateUpdateProductRequest(UpdateProductRequest updateProductRequest) throws ValidationException {
        Set<String> errorCodes = new HashSet<>();
        if(StringUtils.isNullOrZero(updateProductRequest.getProductId())) {
            errorCodes.add(ErrorCodes.INVALID_PRODUCT_ID);
        }
        if(StringUtils.isNullOrEmpty(updateProductRequest.getProductName())) {
            errorCodes.add(ErrorCodes.INVALID_PRODUCT_NAME);
        }
        if(StringUtils.isNullOrEmpty(updateProductRequest.getProductColor())) {
            errorCodes.add(ErrorCodes.INVALID_PRODUCT_COLOR);
        }

        if(StringUtils.isNullOrZero(updateProductRequest.getProductPrice())) {
            errorCodes.add(ErrorCodes.INVALID_PRODUCT_PRICE);
        }
        if(!errorCodes.isEmpty()) {
            throw new ValidationException(errorCodes);
        }
    }

}
