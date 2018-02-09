package com.mp.onlinestore.controller;

import com.mp.onlinestore.Exceptions.GenericException;
import com.mp.onlinestore.model.Category;
import com.mp.onlinestore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/category", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public boolean createCategory(@RequestBody final Category category) throws GenericException {
        return categoryService.createCategory(category);
    }

    @RequestMapping(value = "/category/{categoryId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Category findById(@PathVariable("categoryId") final Long categoryId) throws GenericException {
        return categoryService.findById(categoryId);
    }

    @RequestMapping(value = "/category", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public boolean updateCategory(@RequestBody final Category category) throws GenericException {
        return categoryService.updateCategory(category);
    }

    @RequestMapping(value = "/category/{categoryId}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public boolean deleteCategory(@PathVariable("categoryId") final Long categoryId) throws GenericException {
        return categoryService.deleteCategory(categoryId);
    }

    @RequestMapping(value = "/category/all", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Collection<Category> findAll() throws GenericException {
        return categoryService.findAll();
    }
}
