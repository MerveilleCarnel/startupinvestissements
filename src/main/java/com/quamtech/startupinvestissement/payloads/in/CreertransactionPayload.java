package com.quamtech.startupinvestissement.payloads.in;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data

public class CreertransactionPayload {
    @NotBlank(message = " data requis")
    private LocalDate date;
    @NotBlank(message = " prix requis")
    private BigDecimal prix;
    @NotBlank(message = " quantité requis")
    private String qteAction;
    @NotBlank(message = " identifiant requis")
    private String idStartup;
    @NotBlank(message = " identifiant requis")
    private String idIvestisseur;
}

