package com.icloud.jpatest.entity;

import javax.persistence.*;

@Entity
@Table(name = "product_category")
public class ProductCategory {

    @Id
    private String categoryProductId;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

    public String getCategoryProductId() {
        return categoryProductId;
    }

    public void setCategoryProductId(String categoryProductId) {
        this.categoryProductId = categoryProductId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
