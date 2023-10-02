package com.quamtech.startupinvestissement.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

import com.quamtech.startupinvestissement.enumeration.StatutAction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@EntityScan

public class Action {
    @Id
    private String id;
    private BigDecimal prix;
    private LocalDate dateEmission;
    private String qteDisponible;
    private String nomStartup;
    private String nomAction;
    private StatutAction statutAction;
    private String idInvestisseur;
    private String idStartup;
}
