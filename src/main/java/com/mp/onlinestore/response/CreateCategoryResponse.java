package com.mp.onlinestore.response;

public class CreateCategoryResponse extends GeneralResponse {

    private Long categoryId;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public CreateCategoryResponse(String successMessage, Long categoryId) {
        super(successMessage);
        this.categoryId = categoryId;
    }

    public CreateCategoryResponse(Long categoryId) {
        this.categoryId = categoryId;
    }

    public CreateCategoryResponse() {}
}
