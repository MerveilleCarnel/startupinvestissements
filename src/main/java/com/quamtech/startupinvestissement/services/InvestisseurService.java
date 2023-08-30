package com.quamtech.startupinvestissement.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.quamtech.startupinvestissement.Entity.Investisseur;
import com.quamtech.startupinvestissement.Entity.Portefeuille;
import com.quamtech.startupinvestissement.enumeration.Sexe;
import com.quamtech.startupinvestissement.exception.InvestisseurNotFoudException;
import com.quamtech.startupinvestissement.payloads.in.CreerInvestissseurPayload;
import com.quamtech.startupinvestissement.repositories.InvestisseurRepository;
import com.quamtech.startupinvestissement.repositories.PortefeuilleRepository;

import lombok.AllArgsConstructor;

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
            .build();


Portefeuille portefeuille = new Portefeuille();

portefeuille.getActions();
portefeuille.getSolde();

portefeuilleRepository.save(portefeuille); 

  in.getPortefeuille();
    return investRepository.save(in);
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

    public Investisseur updateInvestisseur(CreerInvestissseurPayload creerInvestissseurPayload) throws InvestisseurNotFoudException{
        if (isInvestisseurExistById(creerInvestissseurPayload.getIdInvestisseur())) {
            Investisseur i =  investRepository.findById(creerInvestissseurPayload.getIdInvestisseur()).get();
            i.setNom(creerInvestissseurPayload.getNom());
            i.setPrenom(creerInvestissseurPayload.getPrenom());
            i.setPassword(creerInvestissseurPayload.getPassword());
            i.setEmail(creerInvestissseurPayload.getEmail());
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

    public Page<Investisseur> getAllInvestisseur(Pageable pageable){
        return investRepository.findAll(pageable);
    }

    public List<Investisseur> getAllInvestisseur() {
        return null;
    }
}

