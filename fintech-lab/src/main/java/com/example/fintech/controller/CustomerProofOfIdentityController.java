package com.example.fintech.controller;

import com.example.fintech.entity.CustomerProofOfIdentity;
import com.example.fintech.service.CustomerProofOfIdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proofofidentity")
public class CustomerProofOfIdentityController {

    @Autowired
    private CustomerProofOfIdentityService service;

    @GetMapping
    public List<CustomerProofOfIdentity> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CustomerProofOfIdentity getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public CustomerProofOfIdentity create(@RequestBody CustomerProofOfIdentity input) {
        return service.create(input);
    }

    @PutMapping("/{id}")
    public CustomerProofOfIdentity update(@PathVariable Long id, @RequestBody CustomerProofOfIdentity input) {
        return service.update(id, input);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}