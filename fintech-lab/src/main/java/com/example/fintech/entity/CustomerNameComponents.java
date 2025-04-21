package com.example.fintech.entity;

import jakarta.persistence.*;

@Entity
public class CustomerNameComponents extends AuditFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerIdentifier;
    private String customerNameComponentType;
    private String customerNameValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerIdentifier() {
        return customerIdentifier;
    }

    public void setCustomerIdentifier(String customerIdentifier) {
        this.customerIdentifier = customerIdentifier;
    }

    public String getCustomerNameComponentType() {
        return customerNameComponentType;
    }

    public void setCustomerNameComponentType(String customerNameComponentType) {
        this.customerNameComponentType = customerNameComponentType;
    }

    public String getCustomerNameValue() {
        return customerNameValue;
    }

    public void setCustomerNameValue(String customerNameValue) {
        this.customerNameValue = customerNameValue;
    }
}