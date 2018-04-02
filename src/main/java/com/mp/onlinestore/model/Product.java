package com.mp.onlinestore.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Formatter;
import java.util.List;

@Entity
@Table(name="products")
public class Product implements Serializable{
    private static final long serialVersionUID = 4013315260214762135L;

    @Id
    @GeneratedValue( strategy=GenerationType.IDENTITY )
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private double productPrice;

    @Column(name = "product_color")
    private String productColor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(mappedBy = "productList", fetch = FetchType.LAZY)
    private List<Order> orderList;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public Long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getProductColor() {
        return productColor;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Formatter frt = new Formatter(sb);
        String template = "%-3s %-15s %-10s %-10s";
        frt.format(template, this.getProductId(), this.getProductName(), this.getProductPrice(), this.getProductColor()
               /* this.getCategoryId()*/);
        return sb.toString();
    }

    public Product(Long productId, String productName, double productPrice, String productColor, int categoryId) {
        this.productId=productId;
        this.productName=productName;
        this.productPrice=productPrice;
        this.productColor=productColor;
//        this.categoryId=categoryId;
    }

    public Product(String productName, double productPrice, String productColor, int categoryId) {
        this.productName=productName;
        this.productPrice=productPrice;
        this.productColor=productColor;
//        this.categoryId=categoryId;
    }

    public Product() {}
}
