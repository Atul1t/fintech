package com.example.fintech.entity;

import jakarta.persistence.*;

@Entity
public class CustomerDetails extends AuditFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerNumber;

    private String customerType;
    private String customerFullName;
    private String customerDOBDOI;
    private String customerStatus;
    private String customerContactNumber;
    private String customerMobileNumber;
    private String customerEmailId;
    private String customerCountryOfOrigination;

    public Long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Long customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCustomerFullName() {
        return customerFullName;
    }

    public void setCustomerFullName(String customerFullName) {
        this.customerFullName = customerFullName;
    }

    public String getCustomerDOBDOI() {
        return customerDOBDOI;
    }

    public void setCustomerDOBDOI(String customerDOBDOI) {
        this.customerDOBDOI = customerDOBDOI;
    }

    public String getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }

    public String getCustomerContactNumber() {
        return customerContactNumber;
    }

    public void setCustomerContactNumber(String customerContactNumber) {
        this.customerContactNumber = customerContactNumber;
    }

    public String getCustomerMobileNumber() {
        return customerMobileNumber;
    }

    public void setCustomerMobileNumber(String customerMobileNumber) {
        this.customerMobileNumber = customerMobileNumber;
    }

    public String getCustomerEmailId() {
        return customerEmailId;
    }

    public void setCustomerEmailId(String customerEmailId) {
        this.customerEmailId = customerEmailId;
    }

    public String getCustomerCountryOfOrigination() {
        return customerCountryOfOrigination;
    }

    public void setCustomerCountryOfOrigination(String customerCountryOfOrigination) {
        this.customerCountryOfOrigination = customerCountryOfOrigination;
    }
}