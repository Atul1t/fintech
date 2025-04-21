package com.example.fintech.controller;

import com.example.fintech.entity.CustomerIdentification;
import com.example.fintech.service.CustomerIdentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/identification")
public class CustomerIdentificationController {

    @Autowired
    private CustomerIdentificationService service;

    @GetMapping
    public List<CustomerIdentification> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CustomerIdentification getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public CustomerIdentification create(@RequestBody CustomerIdentification input) {
        return service.create(input);
    }

    @PutMapping("/{id}")
    public CustomerIdentification update(@PathVariable Long id, @RequestBody CustomerIdentification input) {
        return service.update(id, input);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}