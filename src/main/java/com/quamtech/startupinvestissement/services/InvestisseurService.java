package com.quamtech.startupinvestissement.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;

import com.quamtech.startupinvestissement.Entity.Action;
import com.quamtech.startupinvestissement.Entity.Investisseur;
import com.quamtech.startupinvestissement.Entity.Portefeuille;

import com.quamtech.startupinvestissement.enumeration.Sexe;
import com.quamtech.startupinvestissement.exception.InvestisseurNotFoudException;
import com.quamtech.startupinvestissement.payloads.in.CreerActionPayload;
import com.quamtech.startupinvestissement.payloads.in.CreerInvestissseurPayload;
import com.quamtech.startupinvestissement.payloads.in.CreerPortefeuillePayload;
import com.quamtech.startupinvestissement.payloads.in.UpdateInvestisseurPayload;
import com.quamtech.startupinvestissement.repositories.InvestisseurRepository;
import com.quamtech.startupinvestissement.repositories.PortefeuilleRepository;

import lombok.AllArgsConstructor;
import lombok.var;

@Service
@AllArgsConstructor
public class InvestisseurService{
    private final InvestisseurRepository investRepository;
    private final PortefeuilleRepository portefeuilleRepository;

    public Investisseur creerInvestisseur(CreerInvestissseurPayload creerInvestisseurpayload) {
        Investisseur in = Investisseur.builder()
            .nom(creerInvestisseurpayload.getNom())
            .prenom(creerInvestisseurpayload.getPrenom())
            .email(creerInvestisseurpayload.getEmail())
            .sexe(Sexe.valueOf(creerInvestisseurpayload.getSexe()))
            .password(creerInvestisseurpayload.getPassword())
            .fonction(creerInvestisseurpayload.getFonction())
            .build();
            var creerPortefeuillePayload = new CreerPortefeuillePayload();
            var port = creerporteFeuille(creerPortefeuillePayload);
            in.setPortefeuille(port);
            return investRepository.save(in);
    }

    public Portefeuille creerporteFeuille(CreerPortefeuillePayload creerPortefeuillePayload){
        Portefeuille portefeuille = Portefeuille.builder()
        .actions(creerPortefeuillePayload.getActions())
        .build();
        var ok = new BigDecimal(0.0);
        portefeuille.setSoldeInvestisseur(ok);
        var creerActionPayload = new CreerActionPayload();
        var act = creerAction(creerActionPayload);
        ArrayList<Action> test = new ArrayList<>();
        test.add(act);
        portefeuille.setActions(test);
        return portefeuilleRepository.save(portefeuille);
    }

    public Action creerAction(CreerActionPayload creerActionPayload){
        Action action = Action.builder()
        .prix(creerActionPayload.getPrix())
        .dateEmission(LocalDate.now())
        .nomStartup(creerActionPayload.getNomStartup())
        .statutAction(creerActionPayload.getStatutAction())
        .qteDisponible(creerActionPayload.getQteDisponible())
        .idInvestisseur(creerActionPayload.getIdIvestisseur())
        .build();
        return action;
    }

/*public InvestisseurService( InvestisseurRepository investRepository, PortefeuilleRepository portefeuilleRepository) {

    this.investRepository= investRepository;
    this.portefeuilleRepository= portefeuilleRepository;

} 


    public List <Investisseur> recupererTousLesUtilisateurs(){
            return investRepository.findAll();*/
        

    public Investisseur getInvestisseurById(String id)  {
        return investRepository.findById(id).get();
    }

    public Investisseur updateInvestisseur(UpdateInvestisseurPayload updateInvestisseurPayload) throws InvestisseurNotFoudException{
        if (isInvestisseurExistById(updateInvestisseurPayload.getIdInvestisseur())) {
            var i =  investRepository.findById(updateInvestisseurPayload.getIdInvestisseur()).get();
            i.setNom(updateInvestisseurPayload.getNom());
            i.setPrenom(updateInvestisseurPayload.getPrenom());
            i.setPassword(updateInvestisseurPayload.getPassword());
            i.setEmail(updateInvestisseurPayload.getEmail());
            
            return investRepository.save(i);
        } else {
            throw new InvestisseurNotFoudException("Aucun investisseur ne correspond à cet id");
        }
    } 

    public void removeInvestisseurById (String id){
      investRepository.deleteById(id);
    }
    
    public boolean isInvestisseurExistById(String id){
        return  investRepository.existsById(id);
    }

    public Investisseur  getOneInvestisseur(String id) throws InvestisseurNotFoudException{
        if (isInvestisseurExistById(id)) {
            Investisseur ro = investRepository.findById(id).get();
            return ro;
        } else {
            throw new InvestisseurNotFoudException("aucun investisseur ne correspond a cet id");
        }
    }

    public List<Investisseur> getAllInvestisseur(){
        return investRepository.findAll();
    }
}

