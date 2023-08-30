package com.quamtech.startupinvestissement.Entity;

import org.springframework.data.annotation.Id;

import com.quamtech.startupinvestissement.enumeration.SecteurActivite;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class Description {
    @Id
    private String id;
    private String presentation;
    private  SecteurActivite secteurActivite;

}
