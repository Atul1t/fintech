package com.example.fintech.repository;

import com.example.fintech.entity.CustomerProofOfIdentity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerProofOfIdentityRepository extends JpaRepository<CustomerProofOfIdentity, Long> {
}