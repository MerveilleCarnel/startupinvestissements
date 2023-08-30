/*package com.quamtech.startupinvestissement.services;

import org.springframework.stereotype.Service;

import com.quamtech.startupinvestissement.Entity.user;
import com.quamtech.startupinvestissement.payloads.in.creeruserpayload;
import com.quamtech.startupinvestissement.repositories.userrepositories;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class userservices {
    
 private final userrepositories Userrepositories;

    public user creerUser(creeruserpayload creeruserpayload ){
        user User = user.builder()
        .login(creeruserpayload.getLogin()) 
        .sexe(creeruserpayload.getSexe())
        .fonction(creeruserpayload.getFonction())
        .password(creeruserpayload.getPassword()).build();
        return Userrepositories.save(User);
        


}

}
*/