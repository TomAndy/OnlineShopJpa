package com.mp.onlinestore.dao;

import com.mp.onlinestore.Exceptions.GenericException;
import com.mp.onlinestore.model.Category;

import java.util.Collection;

public interface CategoryDao {
    boolean createCategory(final Category category) throws GenericException;

    Category findById(final Long categoryID) throws GenericException;

    boolean updateCategory(final Category category) throws GenericException;

    boolean deleteCategory(final Long categoryID) throws GenericException;

    public Collection<Category> findAll() throws GenericException;
}
