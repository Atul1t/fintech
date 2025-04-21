package com.example.fintech.entity;

import jakarta.persistence.*;

@Entity
public class CustomerIdentification extends AuditFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerIdentificationId;

    private String customerIdentificationType;
    private String customerIdentificationItem;

    public Long getCustomerIdentificationId() {
        return customerIdentificationId;
    }

    public void setCustomerIdentificationId(Long customerIdentificationId) {
        this.customerIdentificationId = customerIdentificationId;
    }

    public String getCustomerIdentificationType() {
        return customerIdentificationType;
    }

    public void setCustomerIdentificationType(String customerIdentificationType) {
        this.customerIdentificationType = customerIdentificationType;
    }

    public String getCustomerIdentificationItem() {
        return customerIdentificationItem;
    }

    public void setCustomerIdentificationItem(String customerIdentificationItem) {
        this.customerIdentificationItem = customerIdentificationItem;
    }
}