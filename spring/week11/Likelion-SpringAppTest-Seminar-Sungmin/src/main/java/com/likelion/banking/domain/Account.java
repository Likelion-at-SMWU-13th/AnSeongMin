package com.likelion.banking.domain;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.math.BigDecimal;

/**
 * 계좌 도메인 모델
 */
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String ownerName;

    @Column(nullable = false)
    private BigDecimal amount;
    
    public Account() {
    }
    
    public Account(Long id, String ownerName, BigDecimal amount) {
        this.id = id;
        this.ownerName = ownerName;
        this.amount = amount;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getOwnerName() {
        return ownerName;
    }
    
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    
    public BigDecimal getAmount() {
        return amount;
    }
    
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}