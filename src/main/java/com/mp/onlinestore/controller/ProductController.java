package com.mp.onlinestore.controller;

import com.mp.onlinestore.Exceptions.GenericException;
import com.mp.onlinestore.model.Product;
import com.mp.onlinestore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public boolean createProduct(@RequestBody final Product product) throws GenericException {
        return productService.createProduct(product);
    }

    @RequestMapping(value = "/product/{productId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Product findById(@PathVariable("productId") final Long productId) throws GenericException {
        return productService.findById(productId);
    }

    @RequestMapping(value = "/product", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public boolean updateProduct(@RequestBody final Product product) throws GenericException {
        return productService.updateProduct(product);
    }

    @RequestMapping(value = "/product/{productId}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public boolean deleteProduct(@PathVariable("productId") final Long productId) throws GenericException {
        return productService.deleteProduct(productId);
    }

    @RequestMapping(value = "/product/all", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Collection<Product> findAll() throws GenericException {
        return productService.findAll();
    }
}
