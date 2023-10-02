package com.quamtech.startupinvestissement.payloads.in;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
@Builder
@AllArgsConstructor
@Data


public class CreerUserPayload {
    

   
   @NotBlank(message = "nom requise")
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
