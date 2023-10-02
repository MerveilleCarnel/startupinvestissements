package com.quamtech.startupinvestissement.services;



import java.util.List;

import org.springframework.stereotype.Service;


import com.quamtech.startupinvestissement.Entity.Startup;

import com.quamtech.startupinvestissement.exception.StartupNotFoundException;
import com.quamtech.startupinvestissement.payloads.in.CreerStartupPayload;
import com.quamtech.startupinvestissement.payloads.in.UpdateStartupPayload;
import com.quamtech.startupinvestissement.repositories.StartupRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StartupService {
    private final StartupRepository startupRepository;

    public Startup CreerStartup( CreerStartupPayload CreerSatrtupPayload){
        Startup ko = Startup.builder()
        .nomStartup(CreerSatrtupPayload.getNomStartup())
        .montantCote(CreerSatrtupPayload.getMontantCote())
        .adresse(CreerSatrtupPayload.getAdresse())
        .tel(CreerSatrtupPayload.getTel())
        .email(CreerSatrtupPayload.getEmail())
        .fonction(CreerSatrtupPayload.getFonction())
        . action(CreerSatrtupPayload.getNomAction())
        
        .build();
        return startupRepository.save(ko);
    }


    public Startup getStartupById(String id)  {
        return startupRepository.findById(id).get();

}
 public boolean isStartupExistById(String id){
        return  startupRepository.existsById(id);
    }

public Startup updateStartup(UpdateStartupPayload updateStartupPayload ) throws StartupNotFoundException{
        if (isStartupExistById(updateStartupPayload.getIdStartup())) {
            Startup w=  startupRepository.findById(updateStartupPayload.getIdStartup()).get();
            w.setNomStartup(updateStartupPayload.getNomStartup());
            w.setMontantCote(updateStartupPayload.getMontantCote());
            w.setAdresse(updateStartupPayload.getAdresse());
            w.setEmail(updateStartupPayload.getEmail());
            w.setTel(updateStartupPayload.getTel());
            
            return startupRepository.save(w);
        } else {
            throw new StartupNotFoundException("Aucune startup ne correspond à cet id");
        }
    } 
    public Startup  getOneStartup(String id) throws StartupNotFoundException{
        if (isStartupExistById(id)) {
            Startup bo = startupRepository.findById(id).get();
            return bo;
        } else {
            throw new StartupNotFoundException("aucune startup ne correspond a cet id");
        }
    }

    public List<Startup> getAllStartup(){
        return startupRepository.findAll();
    }


    
public void removeStartupById (String id){
      startupRepository.deleteById(id);
    }

}