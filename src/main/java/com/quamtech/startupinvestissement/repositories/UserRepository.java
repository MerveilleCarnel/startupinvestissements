package com.quamtech.startupinvestissement.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.quamtech.startupinvestissement.Entity.User;



public interface UserRepository extends MongoRepository<User,String> {
    
    public Optional<User> findById(String id);
    public List<User> findAll();
    
    public Optional<User> findByNomAndPassword(String nom, String password);

}
