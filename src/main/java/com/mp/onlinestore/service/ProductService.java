package com.mp.onlinestore.service;

import com.mp.onlinestore.exceptions.GenericException;
import com.mp.onlinestore.model.Product;

import java.util.Collection;

public interface ProductService {

    Product createProduct(final Product product) throws GenericException;

    Product findById(final Long productId) throws GenericException;

    Product updateProduct(final Product product) throws GenericException;

    Product deleteProduct(final Long productId) throws GenericException;

    public Collection<Product> findAll() throws GenericException;
}
