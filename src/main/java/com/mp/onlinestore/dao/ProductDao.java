package com.mp.onlinestore.dao;

import com.mp.onlinestore.exceptions.GenericException;
import com.mp.onlinestore.model.Product;

import java.util.Collection;

public interface ProductDao {

    Product createProduct(final Product product) throws GenericException;

    Product findById(final Long productId) throws GenericException;

    Product updateProduct(final Product product) throws GenericException;

    Product deleteProduct(final Long productId) throws GenericException;

    public Collection<Product> findAll() throws GenericException;
}
