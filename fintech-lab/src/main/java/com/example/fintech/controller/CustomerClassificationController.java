package com.example.fintech.controller;

import com.example.fintech.entity.CustomerClassification;
import com.example.fintech.service.CustomerClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classifications")
public class CustomerClassificationController {

    @Autowired
    private CustomerClassificationService service;

    @GetMapping
    public List<CustomerClassification> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CustomerClassification getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public CustomerClassification create(@RequestBody CustomerClassification input) {
        return service.create(input);
    }

    @PutMapping("/{id}")
    public CustomerClassification update(@PathVariable Long id, @RequestBody CustomerClassification input) {
        return service.update(id, input);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
