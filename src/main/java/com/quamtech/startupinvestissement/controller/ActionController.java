package com.quamtech.startupinvestissement.controller;



import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quamtech.startupinvestissement.Entity.Action;
import com.quamtech.startupinvestissement.exception.ActionNotFoundExeption;
import com.quamtech.startupinvestissement.exception.InvestisseurNotFoudException;
import com.quamtech.startupinvestissement.payloads.in.CreerActionPayload;
import com.quamtech.startupinvestissement.payloads.out.Response;
import com.quamtech.startupinvestissement.services.ActionService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


@RestController
@OpenAPIDefinition
@AllArgsConstructor

public class ActionController {
    private final ActionService actionService;
    @PostMapping(path = "/ajouteraction")
    public ResponseEntity<Action> creerAction(@Valid @RequestBody CreerActionPayload creerActionPayload) throws InvestisseurNotFoudException{
        var nel = actionService.CreerAction(creerActionPayload);
        return new ResponseEntity<Action> (nel,HttpStatus.OK);

      }
      @PostMapping (path ="/ acheter")
      public ResponseEntity<Action> acheterAction(@RequestBody CreerActionPayload creerActionPayload) throws IllegalArgumentException{

      var cou = actionService.acheterAction(creerActionPayload);
        return new ResponseEntity<Action> (cou,HttpStatus.OK);                   

}


@GetMapping( path="/getOneAction")
public ResponseEntity <Action> getOneAction(@RequestParam(name = "id")String id) {
        return ResponseEntity.ok(actionService.getOneAction(id));
    }

    @GetMapping(path = "/getAllAction")
    public ResponseEntity <Response> getAllAction(@RequestParam(name = "page")int page, @RequestParam(name = "nbPage")int nbPage){
        var de = actionService.getAllAction(PageRequest.of(page, nbPage));
        return new  ResponseEntity<Response>(new Response("message",de),HttpStatus.OK);
    }


/*@PostMapping (path = "/afficherPrix")
public ResponseEntity<Action> afficherPrix(@RequestBody String id) throws ActionNotFoundExeption {

    var bar = actionService.afficherPrix(id);
   return new ResponseEntity<Action> (HttpStatus.OK);  */
}






