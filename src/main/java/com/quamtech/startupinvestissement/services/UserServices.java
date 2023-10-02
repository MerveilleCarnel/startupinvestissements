package com.quamtech.startupinvestissement.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.quamtech.startupinvestissement.Entity.User;
import com.quamtech.startupinvestissement.enumeration.Sexe;
import com.quamtech.startupinvestissement.exception.InvestisseurNotFoudException;
import com.quamtech.startupinvestissement.exception.UserNotFoudException;
import com.quamtech.startupinvestissement.payloads.in.CreerUserPayload;
import com.quamtech.startupinvestissement.payloads.in.UpdateUserPayload;
import com.quamtech.startupinvestissement.repositories.UserRepository;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class UserServices {
    
 private final UserRepository userRepository;

    public User creerUser(CreerUserPayload creerUserpayload) {
        User in = User.builder()
            .nom(creerUserpayload.getNom())
            .prenom(creerUserpayload.getPrenom())
            .email(creerUserpayload.getEmail())
            .sexe(Sexe.valueOf(creerUserpayload.getSexe()))
            .password(creerUserpayload.getPassword())
            .fonction(creerUserpayload.getFonction())
            .build();
            return userRepository.save(in);
    }
        
    public User getUserById(String id)  {
        return userRepository.findById(id).get();
    }

    public User updateUser(UpdateUserPayload updateUserPayload) throws UserNotFoudException{
        if (isInvestisseurExistById(updateUserPayload.getIdUser())) {
            var i =  userRepository.findById(updateUserPayload.getIdUser()).get();
            i.setNom(updateUserPayload.getNom());
            i.setPrenom(updateUserPayload.getPrenom());
            i.setPassword(updateUserPayload.getPassword());
            i.setEmail(updateUserPayload.getEmail());
            return userRepository.save(i);
        } else {
            throw new UserNotFoudException("Aucun investisseur ne correspond à cet id");
        }
    } 

    public void removeUserById (String id){
      userRepository.deleteById(id);
    }
    
    public boolean isInvestisseurExistById(String id){
        return  userRepository.existsById(id);
    }

    public User  getOneInvestisseur(String id) throws InvestisseurNotFoudException{
        if (isInvestisseurExistById(id)) {
            User ro = userRepository.findById(id).get();
            return ro;
        } else {
            throw new InvestisseurNotFoudException("aucun investisseur ne correspond a cet id");
        }
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    public boolean Exist(String nom,String password){
        return userRepository.findByNomAndPassword(nom, password) != null;
    }

    public  String login (String nom,String password) throws UserNotFoudException{
        if(loginE(nom, password)){
            User user=userRepository.findByNomAndPassword(nom, password).get();
            var fonction=user.getFonction();
            return fonction;
        }else{
            throw new UserNotFoudException("user not found");
        }
    }

    public boolean loginE(String nom, String password) {
        return userRepository.findByNomAndPassword(nom, password)!=null;
    }

}


