package com.mroczkowski.ecommerce.dao;

import com.mroczkowski.ecommerce.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category")
public interface ProductCategoryRepo extends JpaRepository<ProductCategory, Long> {
}
