package com.quamtech.startupinvestissement.controller;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quamtech.startupinvestissement.Entity.Description;

import com.quamtech.startupinvestissement.exception.IllegalArgumentException;
import com.quamtech.startupinvestissement.payloads.in.CreerDescriptionpayload;

import com.quamtech.startupinvestissement.services.DescriptionService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@OpenAPIDefinition
@CrossOrigin(origins="*")
public class DescriptionController {

    private final DescriptionService descriptionService;
    @PostMapping(path= "/creerdescription")
    public ResponseEntity<Description> creerDescription(@Valid @RequestBody CreerDescriptionpayload creerDescriptionpayload) throws IllegalArgumentException{
        var mer=descriptionService.creerDescription(creerDescriptionpayload);
        return new ResponseEntity<Description> (mer, HttpStatus.OK);
    }
    

  @GetMapping(path = "/getOneDescription")
    public ResponseEntity<Description> getOneDescription(@RequestParam(name = "id")String id) {
        return ResponseEntity.ok(descriptionService.getOneDescription(id));
    }

    @GetMapping(path = "/getAllDescription")
    public ResponseEntity<List<Description>> getAlldescription(){
        var se = descriptionService.getAllDescription();
        return ResponseEntity.ok(se);
    }

    @GetMapping(path = "/rechercherParSecteurActivite")
    public ResponseEntity<List<Description>> rechercherParSecteurActivite(){
           var res = descriptionService.rechercherParSecteurActivite();
           return  ResponseEntity.ok(res);
    }
    


}
