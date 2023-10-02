package com.quamtech.startupinvestissement.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.quamtech.startupinvestissement.Entity.Startup;

public interface StartupRepository extends MongoRepository<Startup, String>{

    public Optional<Startup> findById(String id);
    public Page<Startup> findAll(Pageable pageable);
}

    

