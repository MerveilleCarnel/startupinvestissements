package com.quamtech.startupinvestissement.payloads.in;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.quamtech.startupinvestissement.enumeration.StatutAction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

 @Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreerActionPayload {

    private BigDecimal prix;
    
    private LocalDate dateEmission;
     
    private String nomStartup;
    
    private StatutAction statutAction;
    
    private String qteDisponible;
    
    private String idIvestisseur;
    
    private String idstartup;
     
    private String idAction;

     
}



    