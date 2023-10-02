package com.quamtech.startupinvestissement.payloads.in;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor

public class UpdateStartupPayload {
@NotBlank(message = "id requis")
    private String IdStartup;
    @NotBlank(message = "nom requis")
    private String nomStartup;
     @NotBlank(message = "montant requis")
    private String montantCote;
     @NotBlank(message = "identifiant requis")
    /*private String idDescription;
     @NotBlank(message = "identifiant requis")
    private String idAction;*/
    @NotBlank(message = "adresse requis")
    private String adresse;
    @NotBlank(message = "numero tel requis")
    private Integer tel;
    @Email(message = "email requis")
    private String email;
    private String fonction;
}
