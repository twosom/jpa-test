package com.icloud.jpatest.repository;

import com.icloud.jpatest.entity.Product;
import com.icloud.jpatest.value.ProductId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, ProductId> {
}
