package com.mp.onlinestore.dao.impl;

import com.mp.onlinestore.Exceptions.GenericException;
import com.mp.onlinestore.dao.CategoryDao;
import com.mp.onlinestore.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.List;

@Transactional
@Repository("CategoryDaoImplJpa")
@Qualifier("CategoryDaoImplJpa")
public class CategoryDaoImplJpa implements CategoryDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public boolean createCategory(Category category) throws GenericException {
        entityManager.persist(category);
        return true;
    }

    @Override
    public Category findById(Long categoryID) throws GenericException {
        return entityManager.find(Category.class, categoryID);
    }

    @Override
    public boolean updateCategory(Category category) throws GenericException {
        Category categoryNew = entityManager.find(Category.class, category.getCategoryId());

        if(categoryNew != null)
        {
            categoryNew.setCategoryName(category.getCategoryName());
            entityManager.persist(categoryNew);
            return true;
        }
        else return false;
    }

    @Override
    public boolean deleteCategory(Long categoryID) throws GenericException {
        Category categoryNew = entityManager.find(Category.class, categoryID);

        if(categoryNew != null)
        {
            entityManager.remove(categoryNew);
            return true;
        }
        else return false;
    }

    @Override
    public Collection<Category> findAll() throws GenericException {
        String hql = "FROM Category as atcl ORDER BY atcl.categoryId";
        return (List<Category>) entityManager.createQuery(hql).getResultList();
    }
}
