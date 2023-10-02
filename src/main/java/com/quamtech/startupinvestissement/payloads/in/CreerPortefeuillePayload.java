package com.quamtech.startupinvestissement.payloads.in;

import java.util.ArrayList;


import com.quamtech.startupinvestissement.Entity.Action;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreerPortefeuillePayload {


    private Double soldeInvestisseur;
    private ArrayList<Action> actions;
}
