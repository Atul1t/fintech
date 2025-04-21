package com.example.fintech.repository;

import com.example.fintech.entity.CustomerClassification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerClassificationRepository extends JpaRepository<CustomerClassification, Long> {
}
