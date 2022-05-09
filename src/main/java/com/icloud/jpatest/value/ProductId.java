package com.icloud.jpatest.value;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductId implements Serializable {

    @Column(name = "product_id")
    private String id;

    public ProductId() {

    }

    public ProductId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductId productId = (ProductId) o;
        return Objects.equals(getId(), productId.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
