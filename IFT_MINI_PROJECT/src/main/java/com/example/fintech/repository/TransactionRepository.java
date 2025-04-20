package com.example.fintech.repository;

import com.example.fintech.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	@Query("SELECT t FROM Transaction t WHERE t.user.id = :uid ORDER BY t.date DESC")
	List<Transaction> findByUserId(@Param("uid") Long uid);

}    
