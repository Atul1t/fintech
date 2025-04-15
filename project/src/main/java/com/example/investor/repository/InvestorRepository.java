package com.example.investor.repository;

import com.example.investor.entity.Investor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InvestorRepository extends JpaRepository<Investor, Long> {
    List<Investor> findByNameContainingIgnoreCase(String name);
}
