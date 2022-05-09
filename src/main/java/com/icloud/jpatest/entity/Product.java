package com.icloud.jpatest.entity;

import com.icloud.jpatest.value.CategoryId;
import com.icloud.jpatest.value.ProductId;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {

    @EmbeddedId
    private ProductId productId;

    public ProductId getProductId() {
        return productId;
    }

    public void setProductId(ProductId productId) {
        this.productId = productId;
    }

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "product_category",
            joinColumns = @JoinColumn(name = "product_id"))
    private Set<CategoryId> categoryIds;

    public Set<CategoryId> getCategoryIds() {
        return categoryIds;
    }
}
