package com.example.fintech.controller;

import com.example.fintech.entity.CustomerAddressComponents;
import com.example.fintech.service.CustomerAddressComponentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresscomponents")
public class CustomerAddressComponentsController {

    @Autowired
    private CustomerAddressComponentsService service;

    @GetMapping
    public List<CustomerAddressComponents> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CustomerAddressComponents getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public CustomerAddressComponents create(@RequestBody CustomerAddressComponents input) {
        return service.create(input);
    }

    @PutMapping("/{id}")
    public CustomerAddressComponents update(@PathVariable Long id, @RequestBody CustomerAddressComponents input) {
        return service.update(id, input);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}