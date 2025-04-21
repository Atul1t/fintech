package com.example.fintech.controller;

import com.example.fintech.entity.CustomerDetails;
import com.example.fintech.service.CustomerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/details")
public class CustomerDetailsController {

    @Autowired
    private CustomerDetailsService service;

    @GetMapping
    public List<CustomerDetails> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CustomerDetails getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public CustomerDetails create(@RequestBody CustomerDetails input) {
        return service.create(input);
    }

    @PutMapping("/{id}")
    public CustomerDetails update(@PathVariable Long id, @RequestBody CustomerDetails input) {
        return service.update(id, input);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}