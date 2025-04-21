package com.example.fintech.service;

import com.example.fintech.entity.CustomerProofOfIdentity;
import com.example.fintech.repository.CustomerProofOfIdentityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerProofOfIdentityService {

    @Autowired
    private CustomerProofOfIdentityRepository repository;

    public List<CustomerProofOfIdentity> getAll() {
        return repository.findAll();
    }

    public CustomerProofOfIdentity getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public CustomerProofOfIdentity create(CustomerProofOfIdentity input) {
        input.setCrudValue('C');
        input.setEffectiveDate(LocalDate.now());
        input.setUserId("system");
        input.setWorkstationId("WS-001");
        input.setProgramId("SpendNestAPI");
        input.setHostTimestamp(LocalDateTime.now());
        input.setLocalTimestamp(LocalDateTime.now());
        input.setAcceptanceTimestamp(LocalDateTime.now());
        input.setAcceptanceUtcOffset(LocalDateTime.now());
        input.setUuid(UUID.randomUUID().toString());

        return repository.save(input);
    }

    public CustomerProofOfIdentity update(Long id, CustomerProofOfIdentity updated) {
        CustomerProofOfIdentity existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setCrudValue('U');
            existing.setHostTimestamp(LocalDateTime.now());
            existing.setLocalTimestamp(LocalDateTime.now());
            return repository.save(existing);
        }
        return null;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
