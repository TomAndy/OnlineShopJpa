package com.mp.onlinestore.converter;

import com.mp.onlinestore.dto.ProductDto;
import com.mp.onlinestore.exceptions.GenericException;
import com.mp.onlinestore.model.Product;
import com.mp.onlinestore.request.CreateProductRequest;
import com.mp.onlinestore.request.UpdateProductRequest;
import com.mp.onlinestore.response.*;
import com.mp.onlinestore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class ProductConverter {

    @Autowired
    private CategoryService categoryService;

    public Product convertProductDtoToProduct(ProductDto productDto) throws GenericException{
        Product product = new Product();
        product.setProductId(productDto.getProductId());
        product.setProductName(productDto.getProductName());
        product.setProductColor(productDto.getProductColor());
        product.setProductPrice(productDto.getProductPrice());
        product.setCategory(categoryService.findById(productDto.getCategoryId()));
        return product;
    }

    public ProductDto convertProductToProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setProductId(product.getProductId());
        productDto.setProductName(product.getProductName());
        productDto.setProductColor(product.getProductColor());
        productDto.setProductPrice(product.getProductPrice());
        productDto.setCategoryId(product.getCategory().getCategoryId());
        return productDto;
    }

    public Product convertCreateProductRequestToProduct(CreateProductRequest createProductRequest) {
        Product product = new Product();
        if(createProductRequest != null) {
            product.setProductName(createProductRequest.getProductName());
            product.setProductColor(createProductRequest.getProductColor());
            product.setProductPrice(createProductRequest.getProductPrice());
            product.setCategory(createProductRequest.getCategory());
        }
        return product;
    }

    public CreateProductResponse convertProductToCreateProductResponse(Product product) {
        CreateProductResponse createProductResponse = new CreateProductResponse();
        if(product != null) {
            createProductResponse.setProductId(product.getProductId());
            createProductResponse.setSuccessMessage("Product was created");
        }
        else {
            createProductResponse.setSuccessMessage("Product was not created");
        }
        return createProductResponse;
    }

    public GetProductResponse convertProductToGetProductResponse(Product product) {
        GetProductResponse getProductResponse = new GetProductResponse();
        if(product!= null) {
            getProductResponse.setProductId(product.getProductId());
            getProductResponse.setProductName(product.getProductName());
            getProductResponse.setProductColor(product.getProductColor());
            getProductResponse.setProductPrice(product.getProductPrice());
            getProductResponse.setCategory(product.getCategory());
            getProductResponse.setOrderList(product.getOrderList());
        }
        return getProductResponse;
    }

    public Product convertUpdateProductRequestToProduct(UpdateProductRequest updateProductRequest) {
        Product product = new Product();
        if(updateProductRequest != null) {
            product.setProductId(updateProductRequest.getProductId());
            product.setProductName(updateProductRequest.getProductName());
            product.setProductColor(updateProductRequest.getProductColor());
            product.setProductPrice(updateProductRequest.getProductPrice());
        }
        return product;
    }

    public UpdateProductResponse convertProductToUpdateProductResponse(Product product) {
        UpdateProductResponse updateProductResponse = new UpdateProductResponse();
        if(product != null) {
            updateProductResponse.setProductId(product.getProductId());
            updateProductResponse.setSuccessMessage("Product was updated");
        }
        else {
            updateProductResponse.setSuccessMessage("Product was not updated");
        }
        return updateProductResponse;
    }

    public DeleteProductResponse convertProductToDeleteProductResponse(Product product) {
        DeleteProductResponse deleteProductResponse = new DeleteProductResponse();
        if(product != null) {
            deleteProductResponse.setProductId(product.getProductId());
            deleteProductResponse.setSuccessMessage("Product was deleted");
        }
        else {
            deleteProductResponse.setSuccessMessage("Product was not deleted");
        }
        return deleteProductResponse;
    }

    public GetAllProductResponse convertProductsToGetAllProductResponse(Collection<Product> listOfProducts) {
        GetAllProductResponse getAllProductResponse = new GetAllProductResponse();
        if(listOfProducts.size() != 0) {
            getAllProductResponse.setListOfProducts(listOfProducts);
        }
        return getAllProductResponse;
    }

}
