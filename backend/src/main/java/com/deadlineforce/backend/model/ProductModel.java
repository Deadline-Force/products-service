package com.deadlineforce.backend.model;

import com.deadlineforce.backend.entity.Product;
import com.deadlineforce.backend.repository.ProductRepository;
import com.deadlineforce.backend.service.product.ProductService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductModel {
    private final ProductRepository productRepository;
    private final ProductService productService;

    public ProductModel(ProductRepository productRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }

    public List<Product> getTopProductsByTransactions() {
        return this.productService.getTopProducts();
    }
}