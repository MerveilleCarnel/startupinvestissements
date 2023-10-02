package com.quamtech.startupinvestissement.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import com.quamtech.startupinvestissement.enumeration.Sexe;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@Builder 
@NoArgsConstructor
public class Investisseur {
    @Id
    private String id;
    private String nom;
    private String prenom;
    private String password;
    private Sexe sexe ;
    private String email;
    private Integer tel;
    private String fonction;

@DBRef        /*specifie que chaque investisseur a un seul portefeuille. lorsqu'un investisseur est crée un portefeuille sera automatiquement 
crée et lié à cet investisseur grace a cet annotation*/

private Portefeuille portefeuille;


}
