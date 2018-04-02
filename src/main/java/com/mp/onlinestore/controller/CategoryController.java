package com.mp.onlinestore.controller;

import com.mp.onlinestore.converter.CategoryConverter;
import com.mp.onlinestore.exceptions.GenericException;
import com.mp.onlinestore.exceptions.ValidationException;
import com.mp.onlinestore.model.Category;
import com.mp.onlinestore.request.CreateCategoryRequest;
import com.mp.onlinestore.request.UpdateCategoryRequest;
import com.mp.onlinestore.response.*;
import com.mp.onlinestore.service.CategoryService;
import com.mp.onlinestore.util.CustomExceptionHandler;
import com.mp.onlinestore.validator.CategoryValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CategoryValidator categoryValidator;
    @Autowired
    private CategoryConverter categoryConverter;
    @Autowired
    private CustomExceptionHandler customExceptionHandler;



    @RequestMapping(value = "/category", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity createCategory(@RequestBody final CreateCategoryRequest createCategoryRequest) {
        CreateCategoryResponse createCategoryResponse = new CreateCategoryResponse();
        try {
            categoryValidator.validateCreateCategoryRequest(createCategoryRequest);
            Category category = categoryConverter.convertCreateCategoryRequestToCategory(createCategoryRequest);
            Category categoryCreated = categoryService.createCategory(category);
            createCategoryResponse = categoryConverter.convertCategoryToCreateCategoryResponse(categoryCreated);
            return  ResponseEntity.ok(createCategoryResponse);
        } catch (Exception exception) {
            return  ResponseEntity.ok(customExceptionHandler.handleErrorResponse(exception));
        }
    }

//    @RequestMapping(value = "/category", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE},
//            produces = {MediaType.APPLICATION_JSON_VALUE})
//    public CreateCategoryResponse createCategory(@RequestBody final CreateCategoryRequest createCategoryRequest) throws GenericException {
//        CreateCategoryResponse createCategoryResponse = new CreateCategoryResponse();
//        try {
//            categoryValidator.validateCreateCategoryRequest(createCategoryRequest);
//            Category category = categoryConverter.convertCreateCategoryRequestToCategory(createCategoryRequest);
//            Category categoryCreated = categoryService.createCategory(category);
//            createCategoryResponse = categoryConverter.convertCategoryToCreateCategoryResponse(categoryCreated);
//        } catch (ValidationException ve) {
//            customExceptionHandler.printValidationExceptions(ve);
//            createCategoryResponse.setSuccessMessage("Category was not created. Verify all required fields");
////            ve.printStackTrace();
//        } catch (Exception e) {
//            System.out.println("Server error");
//            e.printStackTrace();
//        }
//        return createCategoryResponse;
//    }

    @RequestMapping(value = "/category/{categoryId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public GetCategoryResponse findById(@PathVariable("categoryId") final Long categoryId) throws GenericException {
        GetCategoryResponse getCategoryResponse = new GetCategoryResponse();
        Category category = categoryService.findById(categoryId);
        getCategoryResponse = categoryConverter.convertCategoryToGetCategoryResponse(category);
        return getCategoryResponse;
    }

    @RequestMapping(value = "/category", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public UpdateCategoryResponse updateCategory(@RequestBody final UpdateCategoryRequest updateCategoryRequest) throws GenericException {
        UpdateCategoryResponse updateCategoryResponse = new UpdateCategoryResponse();
        try {
            categoryValidator.validateUpdateCategoryRequest(updateCategoryRequest);
            Category category = categoryConverter.convertUpdateCategoryRequestToCategory(updateCategoryRequest);
            Category categoryUpdated = categoryService.updateCategory(category);
            updateCategoryResponse = categoryConverter.convertCategoryToUpdateCategoryResponse(categoryUpdated);
        } catch (ValidationException ve) {
            customExceptionHandler.printValidationExceptions(ve);
            updateCategoryResponse.setSuccessMessage("Category was not updated. Verify all required fields");
//            ve.printStackTrace();
        } catch (Exception e) {
            System.out.println("Server error");
            e.printStackTrace();
        }
        return updateCategoryResponse;
    }

    @RequestMapping(value = "/category/{categoryId}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public DeleteCategoryResponse deleteCategory(@PathVariable("categoryId") final Long categoryId) throws GenericException {
        Category category = categoryService.deleteCategory(categoryId);
        DeleteCategoryResponse deleteCategoryResponse = categoryConverter.convertCategoryToDeleteCategoryResponse(category);
        return deleteCategoryResponse;
    }

    @RequestMapping(value = "/category/all", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public GetAllCategoryResponse findAll() throws GenericException {
        GetAllCategoryResponse getAllCategoryResponse = new GetAllCategoryResponse();
        Collection<Category> listOfCategories = categoryService.findAll();
                getAllCategoryResponse = categoryConverter.convertCategoriesToGetAllCategoryResponse(listOfCategories);
        return getAllCategoryResponse;
    }


}
