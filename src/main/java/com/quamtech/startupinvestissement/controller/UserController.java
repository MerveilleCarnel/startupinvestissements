package com.quamtech.startupinvestissement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quamtech.startupinvestissement.Entity.User;
import com.quamtech.startupinvestissement.exception.UserNotFoudException;
import com.quamtech.startupinvestissement.payloads.in.CreerUserPayload;
import com.quamtech.startupinvestissement.payloads.in.UpdateUserPayload;
import com.quamtech.startupinvestissement.services.UserServices;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor

public class UserController {
    
    private final UserServices userServices;

  
  @PostMapping(path = "/creerUser")
    public ResponseEntity<User> creerUser(@RequestBody @Valid CreerUserPayload creerUserpayload){
        var u = userServices.creerUser(creerUserpayload);
        return new ResponseEntity<>(u,HttpStatus.OK);
    }


 @GetMapping(path = "/getOneUser/{Id}")
    public ResponseEntity<User> getOneInvestisseur(@PathVariable(name = "Id") String id) throws UserNotFoudException {
        return ResponseEntity.ok(userServices.getUserById(id));
    }

    @GetMapping(path = "/getAllUser")
    public ResponseEntity<List<User>> getAllUser(){
        var res = userServices.getAllUser();
        return ResponseEntity.ok(res);
    }

    @PutMapping(path = "/updateUser")
        public ResponseEntity<User> updateUser(@RequestBody UpdateUserPayload updateUserPayload) throws UserNotFoudException {
        return ResponseEntity.ok(userServices.updateUser(updateUserPayload));

    }

    @DeleteMapping(path="/deleteInvestisseur")
    public ResponseEntity<HttpStatus> deleteInvestisseurById(@PathVariable(name = "id") String id){
        userServices.removeUserById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED); 
    }

     @GetMapping(path = "/login")
    public ResponseEntity<Object> getfonction(@RequestParam(name = "nom")String nom, @RequestParam(name = "password")String password) throws UserNotFoudException{
        
        return ResponseEntity.ok(userServices.login(nom, password));
    }

 


  }













