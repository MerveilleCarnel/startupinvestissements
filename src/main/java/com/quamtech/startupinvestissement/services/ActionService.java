package com.quamtech.startupinvestissement.services;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.quamtech.startupinvestissement.Entity.Action;
import com.quamtech.startupinvestissement.enumeration.StatutAction;
import com.quamtech.startupinvestissement.payloads.in.CreerActionPayload;
import com.quamtech.startupinvestissement.repositories.ActionRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ActionService {
    private final ActionRepository actionRepository;
    //private Action action;
    //private final InvestisseurRepository investisseurRepository;

    public Action CreerAction (CreerActionPayload creerActionPayload) {
       // if(investisseurRepository.existsById(creerActionPayload.getIdIvestisseur())){
        Action ca = Action.builder()
        .prix (creerActionPayload.getPrix())
        .dateEmission(creerActionPayload.getDateEmission())
        .qteDisponible(creerActionPayload.getQteDisponible())
        .nomStartup(creerActionPayload.getNomStartup())
        .statutAction(StatutAction.valueOf(creerActionPayload.getStatutAction())).idInvestisseur(creerActionPayload.getIdIvestisseur())   
        .build();
        actionRepository.save(ca);
        return ca;
    }
    


    public Action getOneAction (String id) {
         return actionRepository.findById(id).get();
    }

    public Page<Action> getAllAction(Pageable pageable){
        return actionRepository.findAll(pageable);
    }
    
    public Page<Action>rechercherParnomStartup(String nomStartup, Pageable pageable){
        return actionRepository.findAllByNomStartup(nomStartup, pageable);         
    }

        public Action acheterAction (CreerActionPayload creerActionPayload) throws IllegalArgumentException{
                Action action= Action.builder()
                .prix (creerActionPayload.getPrix())
                .dateEmission(creerActionPayload.getDateEmission())
                .qteDisponible(creerActionPayload.getQteDisponible())
                .nomStartup(creerActionPayload.getNomStartup())
                .idInvestisseur(creerActionPayload.getIdIvestisseur())
                .statutAction(StatutAction.EN_ATTENTE).build();
                // .idInvestisseur(creerActionPayload.getIdIvestisseur())
         return  actionRepository.save(action); 
  
     /*
      String Idaction= creerActionPayload.getIdAction();
     String IdIvestisseur= creerActionPayload.getIdIvestisseur();
     // recupere l'action a acheter depuis la BD
     Action action = actionRepository.findById(IdAction)

     ActionRepository.Save(action);// enregistre les modification dans la BD
      */
  }
     

   /*
     public Integer afficherPrix(String id)throws  ActionNotFoundExeption{
        var a = actionRepository.findById(id).get();
        Integer d= action.getPrix();
        if(isExist(id)){  
        return d;    
        }else{
        throw new ActionNotFoundExeption("cette id n'existe pas");
     }
    }
    */

    public boolean isExist(String id){
        var v=actionRepository.existsById(id);
        return v;
    }

}





