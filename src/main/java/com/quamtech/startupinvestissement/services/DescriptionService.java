package com.quamtech.startupinvestissement.services;

import java.util.List;


import org.springframework.stereotype.Service;

import com.quamtech.startupinvestissement.Entity.Description;

import com.quamtech.startupinvestissement.exception.DescriptionNotFoundException;
import com.quamtech.startupinvestissement.exception.IllegalArgumentException;
import com.quamtech.startupinvestissement.payloads.in.CreerDescriptionpayload;
import com.quamtech.startupinvestissement.payloads.in.UpadateDescriptionPayload;
import com.quamtech.startupinvestissement.repositories.DescriptionRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DescriptionService {
    private final DescriptionRepository descriptionRepository;

     public  Description creerDescription(CreerDescriptionpayload creerDescriptionpayload) throws IllegalArgumentException{

    Description ro= Description.builder()
    .presentation(creerDescriptionpayload.getPresentation())
    .secteurActivite(creerDescriptionpayload.getSecteurActivite())
    .build(); 
    return descriptionRepository.save(ro);

    }

    public Description getOneDescription (String id){
        return descriptionRepository.findById(id).get();
    }

    public List<Description> getAllDescription(){
        return descriptionRepository.findAll();
    }
    
    public List<Description>rechercherParSecteurActivite(){
        return descriptionRepository.findAll();    
    }
    public boolean isDescriptionExistById(String id){

        return descriptionRepository.existsById(id);
    }



 public Description updateDescription(UpadateDescriptionPayload upadateDescriptionpayload) throws DescriptionNotFoundException{ 
        if(isDescriptionExistById(upadateDescriptionpayload.getIdDescription())){
        Description d= descriptionRepository.findById(upadateDescriptionpayload.getIdDescription()).get();
        d.setPresentation(upadateDescriptionpayload.getPresentation());
        d.setSecteurActivite(upadateDescriptionpayload.getSecteurActivite());
        d = descriptionRepository.save(d);
        return d;
        }
        else {
            throw new DescriptionNotFoundException("Aucune description ne correspond à cet id");
        }
}

    public void removeDescriptionById (String id){
      descriptionRepository.deleteById(id);
    }


}
