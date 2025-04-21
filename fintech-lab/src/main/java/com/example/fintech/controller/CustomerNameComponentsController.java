package com.example.fintech.controller;

import com.example.fintech.entity.CustomerNameComponents;
import com.example.fintech.service.CustomerNameComponentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/namecomponents")
public class CustomerNameComponentsController {

    @Autowired
    private CustomerNameComponentsService service;

    @GetMapping
    public List<CustomerNameComponents> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CustomerNameComponents getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public CustomerNameComponents create(@RequestBody CustomerNameComponents input) {
        return service.create(input);
    }

    @PutMapping("/{id}")
    public CustomerNameComponents update(@PathVariable Long id, @RequestBody CustomerNameComponents input) {
        return service.update(id, input);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}