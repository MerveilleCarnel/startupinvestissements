package com.quamtech.startupinvestissement.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.quamtech.startupinvestissement.Entity.Action;





public interface ActionRepository extends MongoRepository<Action, String>{ 

    public Optional<Action>findById(String id);
    public Optional <Action> findByNomStartup(String nomStartup);
    public Page<Action>findAllByNomStartup(String nomStartup, Pageable pageable);
    public Page<Action>findAll(Pageable pageable);
    public List<Action> findAllByIdInvestisseur(String idInvestisseur);
    public boolean existsByIdInvestisseur(String idInvestisseur);
}
