package com.quamtech.startupinvestissement.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Transaction {
    @Id
    private String id;
    private LocalDate date;
    private BigDecimal prix;
    private String action;
    private String idStartup;
    private String idIvestisseur;
}


