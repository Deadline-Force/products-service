package com.deadlineforce.backend.service.product;

import com.deadlineforce.backend.dao.ProductDao;
import com.deadlineforce.backend.entity.Product;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class ProductService {
    private final AtomicReference<List<Product>> topProducts = new AtomicReference<>();
    private final ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public void setTopProducts(List<Product> products) {
        this.topProducts.set(products);
    }

    public List<Product> getTopProducts() {
        return Collections.unmodifiableList(this.topProducts.get());
    }

    @Scheduled(fixedDelay = 86400000, initialDelay = 0)
    public void updateTop() {
        this.topProducts.set(this.productDao.getTopProductsByTransactions());
    }
}