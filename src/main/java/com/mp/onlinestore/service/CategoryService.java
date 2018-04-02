package com.mp.onlinestore.service;

import com.mp.onlinestore.exceptions.GenericException;
import com.mp.onlinestore.model.Category;

import java.util.Collection;

public interface CategoryService {
    Category createCategory(final Category category) throws GenericException;

    Category findById(final Long categoryID) throws GenericException;

    Category updateCategory(final Category category) throws GenericException;

    Category deleteCategory(final Long categoryID) throws GenericException;

    public Collection<Category> findAll() throws GenericException;
}
