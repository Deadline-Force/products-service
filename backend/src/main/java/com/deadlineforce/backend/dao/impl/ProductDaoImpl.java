package com.deadlineforce.backend.dao.impl;

import com.deadlineforce.backend.dao.ProductDao;
import com.deadlineforce.backend.entity.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class ProductDaoImpl implements ProductDao {
    private static final String TOP_PRODUCTS_QUERY = "SELECT p.* FROM transactions_products tp JOIN products p ON " +
            "tp.product_id = p.product_id WHERE transaction_id = (SELECT transaction_id FROM (SELECT transaction_id, " +
            "COUNT(product_id) cnt FROM transactions_products GROUP BY transaction_id ORDER BY cnt DESC) AS tp_g) " +
            "LIMIT 20";
    private static final String PRODUCT_ID_COLUMN = "product_id";
    private static final String PRODUCT_TITLE_COLUMN = "title";
    private static final String PRODUCT_PRICE_COLUMN = "price";

    private final JdbcTemplate jdbcTemplate;

    public ProductDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> getTopProductsByTransactions() {
        return this.jdbcTemplate.query(TOP_PRODUCTS_QUERY, (resSet, rowNum) -> {
            return new Product(resSet.getLong(PRODUCT_ID_COLUMN), resSet.getString(PRODUCT_TITLE_COLUMN),
                    BigDecimal.valueOf(resSet.getDouble(PRODUCT_PRICE_COLUMN)));
        });
    }
}
