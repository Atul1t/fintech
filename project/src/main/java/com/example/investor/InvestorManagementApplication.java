package com.example.investor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class InvestorManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(InvestorManagementApplication.class, args);
    }
}
