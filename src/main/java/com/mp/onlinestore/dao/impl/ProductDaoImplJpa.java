package com.mp.onlinestore.dao.impl;

import com.mp.onlinestore.exceptions.GenericException;
import com.mp.onlinestore.dao.ProductDao;
import com.mp.onlinestore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.List;

@Transactional
@Repository("ProductDaoImplJpa")
@Qualifier("ProductDaoImplJpa")
public class ProductDaoImplJpa implements ProductDao{

    @Autowired
    private EntityManager entityManager;

    @Override
    public Product createProduct(Product product) throws GenericException {
        entityManager.persist(product);
        return product;
    }

    @Override
    public Product findById(Long productId) throws GenericException {
        return entityManager.find(Product.class, productId);
    }

    @Override
    public Product updateProduct(Product product) throws GenericException {
        Product productNew = entityManager.find(Product.class, product.getProductId());

        if(productNew != null)
        {
            productNew.setProductName(product.getProductName());
            productNew.setProductPrice(product.getProductPrice());
            productNew.setProductColor(product.getProductColor());
//            productNew.setCategoryId(product.getCategoryId());
            entityManager.persist(productNew);
            return productNew;
        }
        else return null;
    }

    @Override
    public Product deleteProduct(Long productId) throws GenericException {
        Product productNew = entityManager.find(Product.class, productId);
        Product productDeleted = entityManager.find(Product.class, productId);

        if(productNew != null)
        {
            entityManager.remove(productNew);
            return productDeleted;
        }
        else return null;
    }

    @Override
    public Collection<Product> findAll() throws GenericException {
        String hql = "FROM Product as atcl ORDER BY atcl.productId";
        return (List<Product>) entityManager.createQuery(hql).getResultList();
    }
}
