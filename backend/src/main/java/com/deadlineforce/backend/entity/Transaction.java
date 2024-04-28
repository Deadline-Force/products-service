package com.deadlineforce.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "transactions")
public class Transaction {
    @Id
    @Column(name = "transaction_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @RestResource(exported = false)
    @JoinColumn(name = "user_owner")
    private User userOwner;
    @ManyToMany
    @RestResource(exported = false)
    @JoinTable(
            name = "transactions_products",
            joinColumns = @JoinColumn(name = "transaction_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    public Transaction(User userOwner) {
        this.userOwner = userOwner;
    }
}
