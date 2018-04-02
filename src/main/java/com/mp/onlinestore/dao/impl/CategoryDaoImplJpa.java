package com.mp.onlinestore.dao.impl;

import com.mp.onlinestore.exceptions.GenericException;
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
    public Category createCategory(Category category) throws GenericException {
        entityManager.persist(category);
        return category;
    }

    @Override
    public Category findById(Long categoryID) throws GenericException {
        if(categoryID == null) {
            return null;
        }
        else {
            return entityManager.find(Category.class, categoryID);
        }
    }

    @Override
    public Category updateCategory(Category category) throws GenericException {
        Category categoryNew = entityManager.find(Category.class, category.getCategoryId());

        if(categoryNew != null)
        {
            categoryNew.setCategoryName(category.getCategoryName());
            entityManager.persist(categoryNew);
            return categoryNew;
        }
        else return null;
    }

    @Override
    public Category deleteCategory(Long categoryID) throws GenericException {
        Category categoryNew = entityManager.find(Category.class, categoryID);
        Category categoryDeleted = entityManager.find(Category.class, categoryID);

        if(categoryNew != null)
        {
            entityManager.remove(categoryNew);
            return categoryDeleted;
        }
        else return null;
    }

    @Override
    public Collection<Category> findAll() throws GenericException {
        String hql = "select new Category(atcl.categoryId, atcl.categoryName) FROM Category as atcl ORDER BY atcl.categoryId";
        return (List<Category>) entityManager.createQuery(hql).getResultList();
    }
}
