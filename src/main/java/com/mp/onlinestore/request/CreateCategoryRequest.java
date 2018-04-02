package com.mp.onlinestore.request;

public class CreateCategoryRequest {

    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public CreateCategoryRequest(String categoryName) {
        this.categoryName = categoryName;
    }

    public CreateCategoryRequest() {}
}
