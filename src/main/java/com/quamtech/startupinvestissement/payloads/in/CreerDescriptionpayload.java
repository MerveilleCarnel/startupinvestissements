package com.quamtech.startupinvestissement.payloads.in;

import com.quamtech.startupinvestissement.enumeration.SecteurActivite;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CreerDescriptionpayload {
    @NotBlank(message=" présentation requise")
    private String presentation;
    @NotBlank(message = "secteur_activité requise")
    private String secteurActivite;

    public void validate() throws IllegalArgumentException{
        try {
            SecteurActivite.valueOf(secteurActivite);
        } catch (Exception e) {
            throw new IllegalArgumentException("Le Secteur d'activité est invalide. les valeurs acceptées sont:TIC,SANTE,ENERGIE_ENVIRONNEMENT,AGROTECHNOLOGIE,EDUCATION, FORMATON,TRANSPORT,DIVERTISSEMENT,MEDIA_NUMERIQUE");
        }
    }

}
