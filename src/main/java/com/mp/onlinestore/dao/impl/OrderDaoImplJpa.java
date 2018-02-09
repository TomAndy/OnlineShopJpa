package com.mp.onlinestore.dao.impl;

import com.mp.onlinestore.Exceptions.GenericException;
import com.mp.onlinestore.dao.OrderDao;
import com.mp.onlinestore.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Transactional
@Repository("OrderDaoImplJpa")
@Qualifier("OrderDaoImplJpa")
public class OrderDaoImplJpa implements OrderDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public boolean createOrder(Order order) throws GenericException {
        entityManager.persist(order);
        return true;
    }

    @Override
    public Order findById(Long orderId) throws GenericException {
        return entityManager.find(Order.class, orderId);
    }

    @Override
    public boolean updateOrder(Order order) throws GenericException {
        Order orderNew = entityManager.find(Order.class, order.getOrderId());

        if(orderNew != null)
        {
            orderNew.setOrderStatus(order.getOrderStatus());
            entityManager.persist(orderNew);
            return true;
        }
        else return false;
    }

    @Override
    public boolean deleteOrder(Long orderId) throws GenericException {
        Order orderNew = entityManager.find(Order.class, orderId);

        if(orderNew != null)
        {
            entityManager.remove(orderNew);
            return true;
        }
        else return false;
    }

    @Override
    public Collection<Order> findAll() throws GenericException {
        String hql = "FROM Order as atcl ORDER BY atcl.order_id";
        return (List<Order>) entityManager.createQuery(hql).getResultList();
    }
}
