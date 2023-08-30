package com.quamtech.startupinvestissement.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.quamtech.startupinvestissement.Entity.Description;
import com.quamtech.startupinvestissement.enumeration.SecteurActivite;



public interface DescriptionRepository extends MongoRepository<Description, String>{
    public Optional<Description> findById(String id);
    public Optional<Description> findBySecteurActivite(String secteurActivite);
    public Page<Description> findAllBySecteurActivite(SecteurActivite secteurActivite, Pageable pageable);
    public Page<Description>findAll(Pageable pageable);

}
