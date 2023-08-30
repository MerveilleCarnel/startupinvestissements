package com.quamtech.startupinvestissement.Entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor




public class Portefeuille {
    @Id
    private String id;
    private String idAction;
    private long solde;
    private String actions;
    

}
