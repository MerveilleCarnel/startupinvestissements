package com.quamtech.startupinvestissement.payloads.in;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateUserPayload {

    @NotBlank(message = "nom requis")
    private String idUser;
     private String nom;
    @NotBlank(message = "prenom requis") 
    private String prenom;
    @NotBlank(message = "sexe requis")
    private String sexe;
    @Email(message = "email requis")
     private String email;
    @NotBlank(message = "password requis")
    private String password;
    @NotBlank(message = "fonction requise")
    private String fonction;
}
