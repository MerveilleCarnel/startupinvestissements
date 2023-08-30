/*package com.quamtech.startupinvestissement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quamtech.startupinvestissement.payloads.in.creeruserpayload;
import com.quamtech.startupinvestissement.payloads.out.response;
import com.quamtech.startupinvestissement.services.userservices;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@OpenAPIDefinition
public class Usercontroller {
    
    private final userservices Userservices; 
  
  @PostMapping(path = "/User")
    public ResponseEntity<response> creeruser(@RequestBody creeruserpayload Creeruserpayload){
        var u = Userservices.creerUser(Creeruserpayload);
        return new ResponseEntity<response>(new response("creation reussi",u),HttpStatus.OK);            
    }
} */
