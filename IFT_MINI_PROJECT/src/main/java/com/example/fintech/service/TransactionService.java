package com.example.fintech.service;

import com.example.fintech.entity.Transaction;
import com.example.fintech.repository.UserRepository;
import com.example.fintech.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import com.example.fintech.entity.User;
@Service

public class TransactionService {
    @Autowired private TransactionRepository repo;
    @Autowired
    private UserRepository userRepository;
    public Transaction add(Transaction tx) {
        tx.setDate(LocalDateTime.now());

        User user = tx.getUser();
        double currentBalance = user.getBalance();
        double amount = tx.getAmount();

        // Handle credit/debit logic
        if ("CREDIT".equalsIgnoreCase(tx.getType())) {
            user.setBalance(currentBalance + amount);
        } else if ("DEBIT".equalsIgnoreCase(tx.getType())) {
            user.setBalance(currentBalance - amount);
        }

        userRepository.save(user);
        return repo.save(tx);
    }

    public List<Transaction> findByUser(Long uid) { return repo.findByUserId(uid); }
}
