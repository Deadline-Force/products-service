package com.deadlineforce.backend.repository;

import com.deadlineforce.backend.entity.Transaction;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@Tag(name = "TransactionController")
@RepositoryRestResource(path = "transactions", itemResourceRel = "transactions")
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
