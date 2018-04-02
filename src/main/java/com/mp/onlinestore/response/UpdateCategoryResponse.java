package com.mp.onlinestore.response;

public class UpdateCategoryResponse extends GeneralResponse {

    private Long categoryId;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public UpdateCategoryResponse(String successMessage, Long categoryId) {
        super(successMessage);
        this.categoryId = categoryId;
    }

    public UpdateCategoryResponse(Long categoryId) {
        this.categoryId = categoryId;
    }

    public UpdateCategoryResponse() {}
}
