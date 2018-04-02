package com.mp.onlinestore.response;

public class DeleteCategoryResponse extends GeneralResponse {

    private Long categoryId;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public DeleteCategoryResponse(String successMessage, Long categoryId) {
        super(successMessage);
        this.categoryId = categoryId;
    }

    public DeleteCategoryResponse(Long categoryId) {
        this.categoryId = categoryId;
    }

    public DeleteCategoryResponse() {}
}
