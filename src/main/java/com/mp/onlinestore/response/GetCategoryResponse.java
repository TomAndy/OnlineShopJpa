package com.mp.onlinestore.response;

import com.mp.onlinestore.model.Product;

import java.util.Collection;

public class GetCategoryResponse {

    private Long categoryId;
    private String categoryName;
    private Collection<Product> productList;

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

    public Collection<Product> getProductList() {
        return productList;
    }

    public void setProductList(Collection<Product> productList) {
        this.productList = productList;
    }

    public GetCategoryResponse(Long categoryId, String categoryName, Collection<Product> productList) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.productList = productList;
    }

    public GetCategoryResponse() {}
}
