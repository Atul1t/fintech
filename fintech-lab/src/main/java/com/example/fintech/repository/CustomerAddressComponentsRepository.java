package com.example.fintech.repository;

import com.example.fintech.entity.CustomerAddressComponents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerAddressComponentsRepository extends JpaRepository<CustomerAddressComponents, Long> {
}