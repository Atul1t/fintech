package com.example.fintech.entity;

import jakarta.persistence.*;

@Entity
public class CustomerClassification extends AuditFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerClassificationId;

    private String customerClassificationType;
    private String customerClassificationTypeValue;

    public Long getCustomerClassificationId() {
        return customerClassificationId;
    }

    public void setCustomerClassificationId(Long customerClassificationId) {
        this.customerClassificationId = customerClassificationId;
    }

    public String getCustomerClassificationType() {
        return customerClassificationType;
    }

    public void setCustomerClassificationType(String customerClassificationType) {
        this.customerClassificationType = customerClassificationType;
    }

    public String getCustomerClassificationTypeValue() {
        return customerClassificationTypeValue;
    }

    public void setCustomerClassificationTypeValue(String customerClassificationTypeValue) {
        this.customerClassificationTypeValue = customerClassificationTypeValue;
    }
}