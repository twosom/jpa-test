package com.icloud.jpatest.repository;

import com.icloud.jpatest.entity.Category;
import com.icloud.jpatest.value.CategoryId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, CategoryId> {

}
