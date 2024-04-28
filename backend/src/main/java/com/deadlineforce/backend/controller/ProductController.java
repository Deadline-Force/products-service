package com.deadlineforce.backend.controller;

import com.deadlineforce.backend.entity.Product;
import com.deadlineforce.backend.model.ProductModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@Tag(name = "ProductController")
public class ProductController {
    private final ProductModel productModel;

    public ProductController(ProductModel productModel) {
        this.productModel = productModel;
    }

    @GetMapping("/top")
    public List<Product> topProducts() {
        return this.productModel.getTopProductsByTransactions();
    }
}
