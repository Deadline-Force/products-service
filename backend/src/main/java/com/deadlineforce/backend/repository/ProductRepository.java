package com.deadlineforce.backend.repository;

import com.deadlineforce.backend.entity.Product;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@Tag(name = "ProductController")
@RepositoryRestResource(path = "products", itemResourceRel = "products")
public interface ProductRepository extends JpaRepository<Product, Long> {
}
