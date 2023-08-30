package com.quamtech.startupinvestissement.payloads.in;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Builder
@AllArgsConstructor
@Data
public class CreerInvestissseurPayload {
    @NotBlank(message = "Idijnvestisseur requis")
    private String idInvestisseur;
    @NotBlank(message = "nom requis")
    private String nom;
    @NotBlank(message = "prenom requis")
    private String prenom;
    @NotBlank(message = "sexe requis")
    private String sexe;
    @Email(message = "email requis")
    private String email;
    @NotBlank(message = "password requis")
    private String password;
   
}
