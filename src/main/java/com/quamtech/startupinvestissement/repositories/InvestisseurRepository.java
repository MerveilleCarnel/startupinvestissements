package com.quamtech.startupinvestissement.repositories;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.quamtech.startupinvestissement.Entity.Investisseur;

public interface InvestisseurRepository  extends MongoRepository<Investisseur,String>{
    public Optional<Investisseur> findById(String id);
    public Page<Investisseur> findAll(Pageable pageable);
}
