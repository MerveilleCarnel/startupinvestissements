package com.quamtech.startupinvestissement.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;


import com.quamtech.startupinvestissement.Entity.Portefeuille;



public interface PortefeuilleRepository extends MongoRepository<Portefeuille, String> {
    public Optional<Portefeuille>findById(String id);
    public Page<Portefeuille>findAll(Pageable pageable);
    //public List<Portefeuille> findfindByIdInvestisseur(String idInvestisseur);
}
