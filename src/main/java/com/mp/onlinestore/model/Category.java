package com.mp.onlinestore.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Formatter;

@Entity
@Table(name="categories")
public class Category implements Serializable {
    private static final long serialVersionUID = -8182179822900955421L;

    @Id
    @GeneratedValue( strategy=GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(mappedBy = "category", targetEntity = Product.class)
    private Collection<Product> productList;

    public Collection<Product> getProductList() {
        return productList;
    }

    public void setProductList(Collection<Product> productList) {
        this.productList = productList;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Formatter frt = new Formatter(sb);
        String template = "%-3s %s";
        frt.format(template, this.getCategoryId(), this.getCategoryName());
        return sb.toString();
    }

    public Category(String categoryName) {
        this.categoryName=categoryName;
    }

    public Category(Long categoryId, String categoryName) {
        this.categoryId=categoryId;
        this.categoryName=categoryName;
    }

    public Category() {}
}
