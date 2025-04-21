package com.example.fintech.repository;

import com.example.fintech.entity.CustomerIdentification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerIdentificationRepository extends JpaRepository<CustomerIdentification, Long> {
}