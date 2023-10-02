package com.quamtech.startupinvestissement.payloads.in;

import jakarta.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class CreerStartupPayload {
    
    private String nomStartup;
     
    private String montantCote;
     
   private String nomAction;
    private String adresse;
   
    private Integer tel;
    @Email(message = "email requis")
    private String email;
    private String fonction;
    


}
