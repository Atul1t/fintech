package com.example.fintech.entity;

import jakarta.persistence.*;

@Entity
public class CustomerAddressComponents extends AuditFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerIdentifier;
    private String customerAddressComponentType;
    private String customerAddressValue;

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

    public String getCustomerAddressComponentType() {
        return customerAddressComponentType;
    }

    public void setCustomerAddressComponentType(String customerAddressComponentType) {
        this.customerAddressComponentType = customerAddressComponentType;
    }

    public String getCustomerAddressValue() {
        return customerAddressValue;
    }

    public void setCustomerAddressValue(String customerAddressValue) {
        this.customerAddressValue = customerAddressValue;
    }
}