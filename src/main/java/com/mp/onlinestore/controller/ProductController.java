package com.mp.onlinestore.controller;

import com.mp.onlinestore.converter.ProductConverter;
import com.mp.onlinestore.exceptions.GenericException;
import com.mp.onlinestore.exceptions.ValidationException;
import com.mp.onlinestore.model.Product;
import com.mp.onlinestore.request.CreateProductRequest;
import com.mp.onlinestore.request.UpdateProductRequest;
import com.mp.onlinestore.response.*;
import com.mp.onlinestore.service.ProductService;
import com.mp.onlinestore.util.CustomExceptionHandler;
import com.mp.onlinestore.validator.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductValidator productValidator;
    @Autowired
    private ProductConverter productConverter;
    @Autowired
    private CustomExceptionHandler customExceptionHandler;


    @RequestMapping(value = "/product", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public CreateProductResponse createProduct(@RequestBody final CreateProductRequest createProductRequest) throws GenericException {
        CreateProductResponse createProductResponse = new CreateProductResponse();
        try {
            productValidator.validateCreateProductRequest(createProductRequest);
            Product product = productConverter.convertCreateProductRequestToProduct(createProductRequest);
            Product productCreated = productService.createProduct(product);
            createProductResponse = productConverter.convertProductToCreateProductResponse(productCreated);
        }catch (ValidationException ve) {
            customExceptionHandler.printValidationExceptions(ve);
            createProductResponse.setSuccessMessage("Product was not created. Verify all required fields");
//            ve.printStackTrace();
        }catch (Exception e) {
            System.out.println("Server error");
            e.printStackTrace();
        }
        return createProductResponse;
    }

    @RequestMapping(value = "/product/{productId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public GetProductResponse findById(@PathVariable("productId") final Long productId) throws GenericException {
        Product product = productService.findById(productId);
        GetProductResponse getProductResponse = productConverter.convertProductToGetProductResponse(product);
        return getProductResponse;
    }

    @RequestMapping(value = "/product", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public UpdateProductResponse updateProduct(@RequestBody final UpdateProductRequest updateProductRequest) throws GenericException {
        UpdateProductResponse updateProductResponse = new UpdateProductResponse();
        try {
            productValidator.validateUpdateProductRequest(updateProductRequest);
            Product product = productConverter.convertUpdateProductRequestToProduct(updateProductRequest);
            Product productUpdated = productService.updateProduct(product);
            updateProductResponse = productConverter.convertProductToUpdateProductResponse(productUpdated);
        }catch (ValidationException ve) {
            customExceptionHandler.printValidationExceptions(ve);
            updateProductResponse.setSuccessMessage("Product was not updated. Verify all required fields");
//            ve.printStackTrace();
        }catch (Exception e) {
            System.out.println("Server error");
            e.printStackTrace();
        }
        return updateProductResponse;
    }

    @RequestMapping(value = "/product/{productId}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public DeleteProductResponse deleteProduct(@PathVariable("productId") final Long productId) throws GenericException {
        Product product = productService.deleteProduct(productId);
        DeleteProductResponse deleteProductResponse = productConverter.convertProductToDeleteProductResponse(product);
        return deleteProductResponse;
    }

    @RequestMapping(value = "/product/all", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public GetAllProductResponse findAll() throws GenericException {
        Collection<Product> listOfProducts = productService.findAll();
        GetAllProductResponse getAllProductResponse = productConverter.convertProductsToGetAllProductResponse(listOfProducts);
        return getAllProductResponse;
    }
}
