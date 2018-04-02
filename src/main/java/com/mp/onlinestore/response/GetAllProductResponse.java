package com.mp.onlinestore.response;

import com.mp.onlinestore.model.Product;

import java.util.Collection;

public class GetAllProductResponse {
    private Collection<Product> listOfProducts;

    public Collection<Product> getListOfProducts() {
        return listOfProducts;
    }

    public void setListOfProducts(Collection<Product> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }

    public GetAllProductResponse(Collection<Product> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }

    public GetAllProductResponse() {}
}
