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
    @NotBlank(message = "fonction requise")
    private String fonction;
    /*
    @DBRef        /*specifie que chaque investisseur a un seul portefeuille. lorsqu'un investisseur est crée un portefeuille sera automatiquement 
crée et lié à cet investisseur grace a cet annotation

    private Portefeuille portefeuille;

     */

   
}
