package com.example.fintech.entity;

import jakarta.persistence.*;

@Entity
public class CustomerProofOfIdentity extends AuditFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerIdentifier;
    private String customerProofOfIdType;
    private String customerClassificationTypeValue;
    private String startDate;
    private String endDate;

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

    public String getCustomerProofOfIdType() {
        return customerProofOfIdType;
    }

    public void setCustomerProofOfIdType(String customerProofOfIdType) {
        this.customerProofOfIdType = customerProofOfIdType;
    }

    public String getCustomerClassificationTypeValue() {
        return customerClassificationTypeValue;
    }

    public void setCustomerClassificationTypeValue(String customerClassificationTypeValue) {
        this.customerClassificationTypeValue = customerClassificationTypeValue;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}