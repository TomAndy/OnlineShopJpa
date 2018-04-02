package com.mp.onlinestore.model;

import com.mp.onlinestore.enums.OrderStatusEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="orders")
public class Order implements Serializable {
    private static final long serialVersionUID = 2373107451698266408L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatusEnum orderStatus;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Orders_Products", joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> productList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    public Order(Long orderId, OrderStatusEnum orderStatus) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
//        this.productList = productList;
    }

    public Order(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Order() {}

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Enumerated(EnumType.STRING)
    public OrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    @Enumerated(EnumType.STRING)
    public void setOrderStatus(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("orderId=").append(orderId);
        sb.append(", orderStatus='").append(orderStatus).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
