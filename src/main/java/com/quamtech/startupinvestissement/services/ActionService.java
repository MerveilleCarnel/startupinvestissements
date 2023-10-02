package com.quamtech.startupinvestissement.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.quamtech.startupinvestissement.Entity.Action;
import com.quamtech.startupinvestissement.Entity.Investisseur;
import com.quamtech.startupinvestissement.enumeration.StatutAction;
import com.quamtech.startupinvestissement.exception.ActionNotFoundExeption;
import com.quamtech.startupinvestissement.exception.InvestisseurNotFoudException;
import com.quamtech.startupinvestissement.payloads.in.CreerActionPayload;
import com.quamtech.startupinvestissement.repositories.ActionRepository;
import com.quamtech.startupinvestissement.repositories.InvestisseurRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.var;

@Service
@AllArgsConstructor
@Data
public class ActionService {
    private final ActionRepository actionRepository;
    private final InvestisseurRepository investisseurRepository;


    public Investisseur acheterAction(String idAction, String idInvestisseur) throws ActionNotFoundExeption, InvestisseurNotFoudException {
      var testInvest = investisseurRepository.existsById(idInvestisseur);
      var testact = actionRepository.existsById(idAction);
      if (testInvest) {
        if (testact) {
          var invest = investisseurRepository.findById(idInvestisseur).get();
          var act = actionRepository.findById(idAction).get();
          act.setStatutAction(StatutAction.ACHETER);
          System.out.println("invest ;"+invest);
          System.out.println("act ;"+act);
          var priceAct = act.getPrix();
          var soldInvest = invest.getPortefeuille().getSoldeInvestisseur();
          if (priceAct.compareTo(soldInvest)<0) {
            invest.getPortefeuille().getActions().add(act);
            soldInvest.subtract(priceAct);
            actionRepository.save(act);
            return investisseurRepository.save(invest);
          } else {
            throw new InvestisseurNotFoudException("le solde de l'investisseur avec pour id :"+idInvestisseur+" est insuffisant !!");
          }
          
        } else {
          throw new ActionNotFoundExeption("action avec pour id : "+idAction+"inexistante !!");
        }
      } else {
        throw new InvestisseurNotFoudException("investisseur avec pour id : "+idInvestisseur+"inexistante !!");
      }
    }

    public Action CreerAction (CreerActionPayload creerActionPayload) {
       // if(investisseurRepository.existsById(creerActionPayload.getIdIvestisseur())){
        Action ca = Action.builder()
        .prix (creerActionPayload.getPrix())
        .dateEmission(creerActionPayload.getDateEmission())
        .qteDisponible(creerActionPayload.getQteDisponible())
        .nomStartup(creerActionPayload.getNomStartup())
        .statutAction(StatutAction.EN_ATTENTE)   
        .build();
        actionRepository.save(ca);
        return ca;
    }
     public Action getOneAction (String id) {
         return actionRepository.findById(id).get();
    }
     public List<Action> getAllAction(){
        return actionRepository.findAll();
    }
    
    public Page<Action>rechercherParnomStartup(String nomStartup, Pageable pageable){
        return actionRepository.findAllByNomStartup(nomStartup, pageable);         
    }

    public boolean isActionExistById(String id){
    
        return actionRepository.existsById(id);
    }


public Action updateAction(CreerActionPayload creerActionPayload) throws ActionNotFoundExeption{
        if (isActionExistById(creerActionPayload.getIdAction())) {
            Action w= actionRepository.findById(creerActionPayload.getIdAction()).get();
            w.setNomStartup(creerActionPayload.getNomStartup());
            w.setPrix(creerActionPayload.getPrix());
            w.setDateEmission(creerActionPayload.getDateEmission());
            w.setQteDisponible(creerActionPayload.getQteDisponible());
            w.setStatutAction(creerActionPayload.getStatutAction());
            return actionRepository.save(w);//
        } else {
            throw new ActionNotFoundExeption("Aucune action ne correspond à cet id");
        }
    }
    public void removeActionById (String id){
      actionRepository.deleteById(id);
    }

























        /* public Action acheterAction (CreerActionPayload creerActionPayload)throws IllegalArgumentException{
           String  idInvestisseur = creerActionPayload.getIdIvestisseur();
           // recuperer l'action a acheter depuis la BD    // recuperer l'investisseur qui effectue l'achat depuis la BD
           if(actionRepository.existsById(creerActionPayload.getIdAction()) && investisseurRepository.existsById(creerActionPayload.getIdIvestisseur())){ 
            Action action = actionRepository.findById(creerActionPayload.getIdAction()).get();
            Investisseur  investisseur= investisseurRepository.findById(creerActionPayload.getIdIvestisseur()).get(); 

            // verifier si le solde de l'investisseur est suffisant pour effectuer l'achat
            Portefeuille portefeuille= new Portefeuille();

              BigDecimal SoldeInvestisseur = portefeuille.getSoldeInvestisseur();
                if(SoldeInvestisseur.compareTo(creerActionPayload.getPrix()) < 0){
            throw new IllegalArgumentException("solde insuffissant pour acheter l'action");
     }
// realisons l'achat de l'action
    else{
             Action act= new Action();
 }
// mettons a jour le solde de l'investisseur

SoldeInvestisseur = SoldeInvestisseur.subtract(creerActionPayload.getPrix());

//SoldeInvestisseur = SoldeInvestisseur.Subtract.prixAction();
        portefeuille.setSoldeInvestisseur(SoldeInvestisseur);
     // enregistre les modification dans la BD
        actionRepository.save(action);      
        investisseurRepository.save(investisseur);
        return action;
          
      /*if(investisseurRepository.existsById(creerActionPayload.getIdIvestisseur())){
        Investisseur  investisseur= investisseurRepository.findById(creerActionPayload.getIdIvestisseur()).get();
        //return investisseurRepository.save(investisseur);
         return action; 
      }
          else {
            throw new IllegalArgumentException("Action et investisseur non trouvée");
        }
        
      }
              
//Portefeuille.setSoldeInvestisseur(Portefeuille.getSoldeInvestisseur() - creerActionPayload.getPrix());
// if(Portefeuille.getSoldeInvestisseur() < creerActionPayload.getPrix()){
     


        

      /*else{
        throw new IllegalArgumentException("action non trouvée");
      }
      
     // BigDecimal prixAction = (creerActionPayload.getPrix());
      
   
        vérifions si l'action à été enrégistré avec succes   
      boolean achatActionReussi= (actionAcheter != null);
      return achatActionReussi;
     
    
      String Idaction= creerActionPayload.getIdAction();
     String IdIvestisseur= creerActionPayload.getIdIvestisseur();
     // recupere l'action a acheter depuis la BD
     Action action = actionRepository.findById(IdAction)

     ActionRepository.Save(action);// enregistre les modification dans la BD
      
  
     
     public Integer afficherPrix(String id)throws  ActionNotFoundExeption{
        var a = actionRepository.=findById(id).get();
        Integer d= action.getPrix();
        if(isExist(id)){  
        return d;    
        }else{
        throw new ActionNotFoundExeption("cette id n'existe pas");
     }
    }
    


    public boolean isExist(String id){
        var v=actionRepository.existsById(id);
        return v;
    }*/


  }
