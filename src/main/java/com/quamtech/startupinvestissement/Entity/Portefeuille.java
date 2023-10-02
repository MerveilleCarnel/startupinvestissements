package com.quamtech.startupinvestissement.Entity;

import java.math.BigDecimal;
import java.util.ArrayList;


import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Portefeuille {
    @Id
    private String id;
    private BigDecimal soldeInvestisseur;
    private ArrayList<Action> actions;
    
public BigDecimal getSoldeInvestisseur(){
    return soldeInvestisseur;
}
public BigDecimal setSoldeInvestisseur(){
    return soldeInvestisseur;
}
}
