package com.quamtech.startupinvestissement.repositories;

import java.util.List;
import java.util.Optional;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.quamtech.startupinvestissement.Entity.Description;


public interface DescriptionRepository extends MongoRepository<Description, String>{
    public Optional<Description> findById(String id);
    
    public List<Description>findAll();

}
