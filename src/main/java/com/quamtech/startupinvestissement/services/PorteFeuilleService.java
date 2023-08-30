
/*package com.quamtech.startupinvestissement.services;



import org.springframework.stereotype.Service;

import com.quamtech.startupinvestissement.Entity.Portefeuille;
import com.quamtech.startupinvestissement.exception.ActionNotFoundExeption;
import com.quamtech.startupinvestissement.payloads.in.CreerPortefeuillePayload;
import com.quamtech.startupinvestissement.repositories.PortefeuilleRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor



public class PorteFeuilleService {

    private ActionService a;
    private Portefeuille r;
    private final PortefeuilleRepository portefeuilleRepository;

    public List<Portefeuille> getPorteFeuilleByIdIves(String id) throws InvestisseurNotFoudException{
        if(portefeuilleRepository.existsById(id)){
            return portefeuilleRepository.findfindByIdInvestisseur(id);
        }else{
            throw new InvestisseurNotFoudException("Investisseur non existant");
        }
    }

public Portefeuille creerPortefeuille(CreerPortefeuillePayload creerPortefeuillePayload) throws ActionNotFoundExeption{
        //creerDescriptionpayload.validate();

        var g=a.afficherPrix(creerPortefeuillePayload.getIdAction());
    Portefeuille lo = Portefeuille.builder()
    .idAction(creerPortefeuillePayload.getIdAction())
    
    .idInvestisseur(creerPortefeuillePayload.getIdInvestisseur())
    .build();
    if(a.isExist(creerPortefeuillePayload.getIdAction())){
    r.setPrix(g);
  return portefeuilleRepository.save(lo);
    }
  throw new ActionNotFoundExeption("erreur"); 
}*/

