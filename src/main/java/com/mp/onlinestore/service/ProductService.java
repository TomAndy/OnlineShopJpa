package com.mp.onlinestore.service;

import com.mp.onlinestore.Exceptions.GenericException;
import com.mp.onlinestore.model.Product;

import java.util.Collection;

public interface ProductService {

    boolean createProduct(final Product product) throws GenericException;

    Product findById(final Long productId) throws GenericException;

    boolean updateProduct(final Product product) throws GenericException;

    boolean deleteProduct(final Long productId) throws GenericException;

    public Collection<Product> findAll() throws GenericException;
}
