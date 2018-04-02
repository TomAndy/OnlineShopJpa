package com.mp.onlinestore.response;

import com.mp.onlinestore.model.Category;

import java.util.Collection;

public class GetAllCategoryResponse {

    private Collection<Category> listOfCategories;

    public Collection<Category> getListOfCategories() {
        return listOfCategories;
    }

    public void setListOfCategories(Collection<Category> listOfCategories) {
        this.listOfCategories = listOfCategories;
    }

    public GetAllCategoryResponse(Collection<Category> listOfCategories) {
        this.listOfCategories = listOfCategories;
    }

    public GetAllCategoryResponse() {}
}
