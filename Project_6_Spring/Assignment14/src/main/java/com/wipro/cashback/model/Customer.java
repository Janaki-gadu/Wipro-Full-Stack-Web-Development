package com.wipro.cashback.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @Column(name = "CustomerID", length = 20)
    private String customerId;

    @Column(name = "Password", nullable = false, length = 50)
    private String password;

    @Column(name = "Balance", nullable = false)
    private double balance;

    public Customer() {}

    public Customer(String customerId, String password, double balance) {
        this.customerId = customerId;
        this.password = password;
        this.balance = balance;
    }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
}
