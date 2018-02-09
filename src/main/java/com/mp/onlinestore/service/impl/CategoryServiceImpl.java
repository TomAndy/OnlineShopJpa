package com.mp.onlinestore.service.impl;

import com.mp.onlinestore.Exceptions.GenericException;
import com.mp.onlinestore.dao.CategoryDao;
import com.mp.onlinestore.model.Category;
import com.mp.onlinestore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.logging.Logger;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    @Qualifier("CategoryDaoImplJpa")
    private CategoryDao categoryDao;

    static Logger log = Logger.getLogger(CategoryServiceImpl.class.toString());

    public boolean createCategory(final Category category) throws GenericException {
        log.info("Starting to create category: " + category);

        boolean isCreated = categoryDao.createCategory(category);

        log.info("Finishing to create category. Category created: " + isCreated);
        return isCreated;
    }

    public Category findById(final Long categoryID) throws GenericException {
        log.info("Starting to read category by ID: " + categoryID);

        Category category = categoryDao.findById(categoryID);

        log.info("Finishing to read category. Category data: " + category);
        return category;
    }

    public boolean updateCategory(final Category category) throws GenericException {
        log.info("Starting to update category with new attributes: " + category);

        boolean isUpdated = categoryDao.updateCategory(category);

        log.info("Finishing to update category. Category updated: " + isUpdated);
        return isUpdated;
    }

    public boolean deleteCategory(final Long categoryID) throws GenericException {
        log.info("Starting to delete category with ID: " + categoryID);

        boolean isDeleted = categoryDao.deleteCategory(categoryID);

        log.info("Finishing to delete category. Category deleted: " + isDeleted);
        return isDeleted;
    }

    public Collection<Category> findAll() throws GenericException {
        log.info("Start to read all categories from DB");

        Collection<Category> categoryList = categoryDao.findAll();

        log.info("Finish to read all categories from DB");

        return categoryList;
    }
}
