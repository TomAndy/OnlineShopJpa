package com.mp.onlinestore.dto;

import org.springframework.stereotype.Component;

@Component
public class CategoryDto {

    private Long categoryId;
    private String categoryName;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public CategoryDto(Long categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public CategoryDto() {}

    public String toString() {
        final StringBuilder sb = new StringBuilder("Category{");
        sb.append("categoryId=").append(categoryId);
        sb.append(", categoryName='").append(categoryName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
