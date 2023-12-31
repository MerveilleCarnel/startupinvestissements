package com.quamtech.startupinvestissement.payloads.in;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CreerDescriptionpayload {
    @NotBlank(message=" présentation requise")
    private String presentation;
    @NotBlank(message = "secteur_activité requise")
    private String secteurActivite;
    private String idIvestisseur;
    private String idStartup;


    

}
