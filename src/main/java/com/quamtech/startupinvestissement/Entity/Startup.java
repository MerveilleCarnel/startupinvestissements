package com.quamtech.startupinvestissement.Entity;

import org.springframework.data.annotation.Id;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder    

public class Startup {
    @Id
    private String id;
    private String nomStartup;
    private String montantCote;
    private String action;
    private String adresse;
    private String email;
    private Integer tel;
    private String fonction;

}
