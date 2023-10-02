package com.quamtech.startupinvestissement.Entity;

import org.springframework.data.annotation.Id;


import com.quamtech.startupinvestissement.enumeration.Sexe;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id

    private String id;
    private String nom;
    private String prenom;
    private String password;
    private Sexe sexe ;
    private String email;
    private Integer tel;
    private String fonction;
}
