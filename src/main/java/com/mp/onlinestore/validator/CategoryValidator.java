package com.mp.onlinestore.validator;

import com.mp.onlinestore.consts.ErrorCodes;
import com.mp.onlinestore.exceptions.ValidationException;
import com.mp.onlinestore.request.CreateCategoryRequest;
import com.mp.onlinestore.request.UpdateCategoryRequest;
import com.mp.onlinestore.util.StringUtils;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CategoryValidator {

    public void validateCreateCategoryRequest(CreateCategoryRequest createCategoryRequest) throws ValidationException {
        Set<String> errorCodes = new HashSet<>();
        if(StringUtils.isNullOrEmpty(createCategoryRequest.getCategoryName())) {
            errorCodes.add(ErrorCodes.INVALID_CATEGORY_NAME);
        }
        if(!errorCodes.isEmpty()) {
            throw new ValidationException(errorCodes);
        }
    }

    public void validateUpdateCategoryRequest(UpdateCategoryRequest updateCategoryRequest) throws ValidationException {
        Set<String> errorCodes = new HashSet<>();
        if(StringUtils.isNullOrZero(updateCategoryRequest.getCategoryId())) {
            errorCodes.add(ErrorCodes.INVALID_CATEGORY_ID);
        }
        if(StringUtils.isNullOrEmpty(updateCategoryRequest.getCategoryName())) {
            errorCodes.add(ErrorCodes.INVALID_CATEGORY_NAME);
        }
        if(!errorCodes.isEmpty()) {
            throw new ValidationException(errorCodes);
        }
    }

}
