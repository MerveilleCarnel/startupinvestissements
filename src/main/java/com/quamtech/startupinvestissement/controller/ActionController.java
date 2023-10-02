package com.quamtech.startupinvestissement.controller;



import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.quamtech.startupinvestissement.Entity.Action;
import com.quamtech.startupinvestissement.Entity.Investisseur;
import com.quamtech.startupinvestissement.exception.ActionNotFoundExeption;
import com.quamtech.startupinvestissement.exception.InvestisseurNotFoudException;
import com.quamtech.startupinvestissement.payloads.in.CreerActionPayload;
import com.quamtech.startupinvestissement.services.ActionService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


@RestController
@OpenAPIDefinition
@AllArgsConstructor
@CrossOrigin(origins="*")
public class ActionController {
    private final ActionService actionService;
    @PostMapping(path = "/ajouteraction")
    public ResponseEntity<Action> creerAction(@Valid @RequestBody CreerActionPayload creerActionPayload) throws InvestisseurNotFoudException{
        var nel = actionService.CreerAction(creerActionPayload);
        return new ResponseEntity<Action> (nel,HttpStatus.OK);

      }
      /*
       @PostMapping (path ="/ acheterAction")
      public ResponseEntity<String> acheterAction(@RequestBody CreerActionPayload creerActionPayload) throws IllegalArgumentException{
      actionService.acheterAction(creerActionPayload);
      return ResponseEntity.ok("action achété avec succés");   
     }
       */
      
     
     @PutMapping(value = "/acheter_action")
     public ResponseEntity<Investisseur>acheterAction(String idInvestisseur, String idAction) throws ActionNotFoundExeption, InvestisseurNotFoudException{
      var achat = actionService.acheterAction(idAction, idInvestisseur);
      return new ResponseEntity<Investisseur>(achat,HttpStatus.ACCEPTED);
     }

     
    
       
     /* Action cou = actionService.acheterAction(creerActionPayload);
      try{

        boolean achatActionReussi = actionService.acheterAction(creerActionPayload);
        if(achatActionReussi){
           return ResponseEntity.ok("action achetée avec succés");
        } else{
      throw new IllegalArgumentException("une erreur est survnue lors de l'achat de l'action");
        }*/
        

@GetMapping( path="/getOneAction")
public ResponseEntity <Action> getOneAction(@RequestParam(name = "id")String id) {
        return ResponseEntity.ok(actionService.getOneAction(id));
    }

    @GetMapping(path = "/getAllAction")
    public ResponseEntity <List<Action>> getAllAction(){
        var de = actionService.getAllAction();
        return  ResponseEntity.ok(de);
    }




/*@PostMapping (path = "/afficherPrix")
public ResponseEntity<Action> afficherPrix(@RequestBody String id) throws ActionNotFoundExeption {

    var bar = actionService.afficherPrix(id);
   return new ResponseEntity<Action> (HttpStatus.OK);  */
}






