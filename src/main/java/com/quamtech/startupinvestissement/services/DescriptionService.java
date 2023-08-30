package com.quamtech.startupinvestissement.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.quamtech.startupinvestissement.Entity.Description;
import com.quamtech.startupinvestissement.enumeration.SecteurActivite;
import com.quamtech.startupinvestissement.exception.IllegalArgumentException;
import com.quamtech.startupinvestissement.payloads.in.CreerDescriptionpayload;
import com.quamtech.startupinvestissement.repositories.DescriptionRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DescriptionService {
    private final DescriptionRepository descriptionRepository;

     public  Description creerDescription(CreerDescriptionpayload creerDescriptionpayload) throws IllegalArgumentException{
        creerDescriptionpayload.validate();
    Description ro= Description.builder()
    .presentation(creerDescriptionpayload.getPresentation())
    .secteurActivite(SecteurActivite.valueOf(creerDescriptionpayload.getSecteurActivite()))
    .build();
    return descriptionRepository.save(ro);

    }

    public Description getOneDescription (String id){
        return descriptionRepository.findById(id).get();
    }

    public Page<Description> getAllDescription(Pageable pageable){
        return descriptionRepository.findAll(pageable);
    }
    
    public Page<Description>rechercherParSecteurActivite(SecteurActivite secteurActivite, Pageable pageable){
        return descriptionRepository.findAllBySecteurActivite(secteurActivite, pageable);    
    }

}
