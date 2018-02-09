package com.mp.onlinestore.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name="orders")
public class Order implements Serializable {
    private static final long serialVersionUID = 2373107451698266408L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long order_id;

   // @Enumerated(EnumType.STRING)
    @Column(name = "status")
    //private StatusTypes status;
    private String status;

    @ManyToMany
    private Collection<Product> productList;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Order(Long order_id, String status) {
        this.order_id = order_id;
        this.status = status;
//        this.productList = productList;
    }

    public Order(String status) {
        this.status = status;
    }

    public Order() {}

    public Long getOrderId() {
        return order_id;
    }

    public void setOrderId(Long order_id) {
        this.order_id = order_id;
    }

//    @Enumerated(EnumType.STRING)
    public String getOrderStatus() {
        return status;
    }

//    @Enumerated(EnumType.STRING)
    public void setOrderStatus(String status) {
        this.status = status;
    }

    public Collection<Product> getProductList() {
        return productList;
    }

    public void setProductList(Collection<Product> productList) {
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
        sb.append("orderId=").append(order_id);
        sb.append(", orderStatus='").append(status).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
