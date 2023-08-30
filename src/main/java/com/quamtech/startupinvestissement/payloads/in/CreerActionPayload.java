package com.quamtech.startupinvestissement.payloads.in;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder

public class CreerActionPayload {
    @NotBlank(message = "prix requis")
    private Integer prix;
    @NotBlank(message = "dateEmission requise")
    private LocalDate dateEmission;
     @NotBlank(message = "nomStartup requis")
    private String nomStartup;
    @NotBlank(message = "statutAction requis")
    private String statutAction;
    @NotBlank(message = "qteDisponible requis")
    private String qteDisponible;
@NotBlank(message = "idIvestisseur requis")
    private String idIvestisseur;
    

}
