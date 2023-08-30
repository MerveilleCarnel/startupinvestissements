package com.quamtech.startupinvestissement.payloads.in;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreerPortefeuillePayload {
    @NotBlank(message = "identifiant requis")
    private String idAction;
    @NotBlank(message = "solde requis")
   private String solde;
   @NotBlank(message = "action réquis")
   private String actions;
}
