package com.mp.onlinestore.converter;

import com.mp.onlinestore.dto.CategoryDto;
import com.mp.onlinestore.model.Category;
import com.mp.onlinestore.request.CreateCategoryRequest;
import com.mp.onlinestore.request.UpdateCategoryRequest;
import com.mp.onlinestore.response.*;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class CategoryConverter {
    public Category convertCategoryDtoToCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setCategoryId(categoryDto.getCategoryId());
        category.setCategoryName(categoryDto.getCategoryName());
        return category;
    }

    public CategoryDto convertCategoryToCategoryDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryId(category.getCategoryId());
        categoryDto.setCategoryName(category.getCategoryName());
        return categoryDto;
    }

    public Category convertCreateCategoryRequestToCategory(CreateCategoryRequest createCategoryRequest) {
        Category category = new Category();

        if(createCategoryRequest != null) {
            category.setCategoryName(createCategoryRequest.getCategoryName());
        }
        return category;
    }

    public CreateCategoryResponse convertCategoryToCreateCategoryResponse(Category category) {
        CreateCategoryResponse createCategoryResponse = new CreateCategoryResponse();

        if(category != null) {
            createCategoryResponse.setCategoryId(category.getCategoryId());
            createCategoryResponse.setSuccessMessage("Category created");
        }
        else {
            createCategoryResponse.setSuccessMessage("Category was not created");
        }

        return createCategoryResponse;
    }

    public GetCategoryResponse convertCategoryToGetCategoryResponse(Category category) {
        GetCategoryResponse getCategoryResponse = new GetCategoryResponse();
        if(category != null) {
            getCategoryResponse.setCategoryId(category.getCategoryId());
            getCategoryResponse.setCategoryName(category.getCategoryName());
//            getCategoryResponse.setProductList(category.getProductList());
        }
        return getCategoryResponse;
    }

    public Category convertUpdateCategoryRequestToCategory(UpdateCategoryRequest updateCategoryRequest) {
        Category category = new Category();
        if(updateCategoryRequest != null) {
            category.setCategoryId(updateCategoryRequest.getCategoryId());
            category.setCategoryName(updateCategoryRequest.getCategoryName());
        }
        return category;
    }

    public UpdateCategoryResponse convertCategoryToUpdateCategoryResponse(Category category) {
        UpdateCategoryResponse updateCategoryResponse = new UpdateCategoryResponse();
        if(category != null) {
            updateCategoryResponse.setCategoryId(category.getCategoryId());
            updateCategoryResponse.setSuccessMessage("Category was updated");
        }
        else {
            updateCategoryResponse.setSuccessMessage("Category was not updated");
        }
        return updateCategoryResponse;
    }

    public DeleteCategoryResponse convertCategoryToDeleteCategoryResponse(Category category) {
        DeleteCategoryResponse deleteCategoryResponse = new DeleteCategoryResponse();
        if(category != null) {
            deleteCategoryResponse.setCategoryId(category.getCategoryId());
            deleteCategoryResponse.setSuccessMessage("Category was deleted");
        }
        else {
            deleteCategoryResponse.setSuccessMessage("Category was not deleted");
        }
        return deleteCategoryResponse;
    }

    public GetAllCategoryResponse convertCategoriesToGetAllCategoryResponse(Collection<Category> listOfCategories) {
        GetAllCategoryResponse getAllCategoryResponse = new GetAllCategoryResponse();
        getAllCategoryResponse.setListOfCategories(listOfCategories);
        return getAllCategoryResponse;
    }

}
