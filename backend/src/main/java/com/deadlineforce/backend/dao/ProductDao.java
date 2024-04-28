package com.deadlineforce.backend.dao;

import com.deadlineforce.backend.entity.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getTopProductsByTransactions();
}
