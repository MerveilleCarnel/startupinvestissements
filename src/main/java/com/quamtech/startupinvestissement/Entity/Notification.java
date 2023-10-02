package com.quamtech.startupinvestissement.Entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Notification {
@Id
    private String id;
    private String destinataire;
    private String expéditeur;
    private String message;
    private LocalDate date;
}
