package com.mp.onlinestore.service.impl;

import com.mp.onlinestore.Exceptions.GenericException;
import com.mp.onlinestore.dao.ProductDao;
import com.mp.onlinestore.model.Product;
import com.mp.onlinestore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.logging.Logger;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    @Qualifier("ProductDaoImplJpa")
    private ProductDao productDao;

    static Logger log = Logger.getLogger(ProductServiceImpl.class.toString());

    @Override
    public boolean createProduct(final Product product) throws GenericException {
        log.info("Start to create product: " + product);

        boolean isCreated = productDao.createProduct(product);

        log.info("Finishing to create product. Product created: " + isCreated);
        return isCreated;
    }

    public Product findById(final Long productId) throws GenericException {
        log.info("Starting to read product by ID: " + productId);

        Product product = productDao.findById(productId);

        log.info("Finishing to read product. Product data: " + product);
        return product;
    }

    public boolean updateProduct(final Product product) throws GenericException {
        log.info("Starting to update product with new attributes: " + product);

        boolean isUpdated = productDao.updateProduct(product);

        log.info("Finishing to update product. Product updated: " + isUpdated);
        return isUpdated;
    }

    public boolean deleteProduct(final Long productId) throws GenericException {
        log.info("Starting to delete product with ID: " + productId);

        boolean isDeleted = productDao.deleteProduct(productId);

        log.info("Finishing to delete product. Product deleted: " + isDeleted);
        return isDeleted;
    }

    public Collection<Product> findAll() throws GenericException {
        log.info("Start to read all products from DB");
        Collection<Product> productList = productDao.findAll();

        log.info("Finish to read all products from DB" + productList);
        return productList;
    }


}
