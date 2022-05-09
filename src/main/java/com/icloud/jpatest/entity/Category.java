package com.icloud.jpatest.entity;

import com.icloud.jpatest.value.CategoryId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryId categoryId;

    public CategoryId getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(CategoryId categoryId) {
        this.categoryId = categoryId;
    }

}
