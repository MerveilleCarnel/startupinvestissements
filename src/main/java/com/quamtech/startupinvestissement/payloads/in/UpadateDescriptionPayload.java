package com.quamtech.startupinvestissement.payloads.in;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpadateDescriptionPayload {
    @NotBlank(message=" Id requis")
    private String IdDescription;
     @NotBlank(message=" présentation requise")
    private String presentation;
    @NotBlank(message = "secteur_activité requise")
    private String secteurActivite;
    private String idIvestisseur;
    private String idStartup;
}
