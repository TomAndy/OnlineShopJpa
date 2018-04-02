package com.mp.onlinestore.dao.impl;

import com.mp.onlinestore.dao.OrderDao;
import com.mp.onlinestore.enums.OrderStatusEnum;
import com.mp.onlinestore.exceptions.GenericException;
import com.mp.onlinestore.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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
    public Order createOrder(Order order) throws GenericException {
        entityManager.persist(order);
        return order;
    }

    @Override
    public Order findById(Long orderId) throws GenericException {
        return entityManager.find(Order.class, orderId);
    }

    @Override
    public Order updateOrder(Order order) throws GenericException {
        Order orderNew = entityManager.find(Order.class, order.getOrderId());

        if(orderNew != null)
        {
            orderNew.setProductList(order.getProductList());
            entityManager.persist(orderNew);
            return orderNew;
        }
        else return null;
    }

    @Override
    public Order deleteOrder(Long orderId) throws GenericException {
        Order orderNew = entityManager.find(Order.class, orderId);
        Order deletedOrder = new Order();
        deletedOrder.setOrderId(orderId);

        if(orderNew != null)
        {
            entityManager.remove(orderNew);
            return deletedOrder;
        }
        else return null;
    }

    @Override
    public Collection<Order> findAll() throws GenericException {
        String hql = "FROM Order as atcl ORDER BY atcl.orderId";
        return (List<Order>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Collection<Order> findByStatus(OrderStatusEnum orderStatus) throws GenericException {
        TypedQuery<Order> q = (TypedQuery<Order>) entityManager.createQuery("select atcl from Order as atcl where orderStatus = :status order by orderId");
        q.setParameter("status",orderStatus);
        return (List<Order>) q.getResultList();
    }
}
