package com.icloud.jpatest;

import com.icloud.jpatest.entity.Category;
import com.icloud.jpatest.entity.Product;
import com.icloud.jpatest.entity.ProductCategory;
import com.icloud.jpatest.repository.CategoryRepository;
import com.icloud.jpatest.repository.ProductCategoryRepository;
import com.icloud.jpatest.repository.ProductRepository;
import com.icloud.jpatest.value.CategoryId;
import com.icloud.jpatest.value.ProductId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ApplicationTests {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @BeforeEach
    void setUp() {

        //TODO 상품 한개를 생성 후 카테고리 여러 개 생성

        Product product = getProduct();
        List<Category> categories = getCategories();
        productRepository.save(product);
        categoryRepository.saveAll(categories);


        categories.forEach(category -> {
            ProductCategory productCategory = new ProductCategory();
            productCategory.setCategoryProductId("product_category_" + categories.indexOf(category));
            productCategory.setCategory(category);
            productCategory.setProduct(product);
            productCategoryRepository.save(productCategory);
        });
    }

    private List<Category> getCategories() {
        return IntStream.rangeClosed(1, 100)
                .mapToObj(i -> {
                    Category category = new Category();
                    category.setCategoryId(new CategoryId("test_category_" + i));
                    return category;
                })
                .toList();
    }

    private Product getProduct() {
        Product product = new Product();
        product.setProductId(new ProductId("test_product"));
        return product;
    }

    @Test
    void test() {
        Product someProduct = productRepository.findAll().get(0);
        assertEquals(100, someProduct.getCategoryIds().size());
    }


}


