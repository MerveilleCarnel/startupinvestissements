package com.quamtech.startupinvestissement.controller;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quamtech.startupinvestissement.Entity.Description;
import com.quamtech.startupinvestissement.enumeration.SecteurActivite;
import com.quamtech.startupinvestissement.exception.IllegalArgumentException;
import com.quamtech.startupinvestissement.payloads.in.CreerDescriptionpayload;
import com.quamtech.startupinvestissement.payloads.out.Response;
import com.quamtech.startupinvestissement.services.DescriptionService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@OpenAPIDefinition
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
    public ResponseEntity<Page<Description>> getAlldescription(@RequestParam(name = "page")int page, @RequestParam(name = "nbPage")int nbPage){
        var se = descriptionService.getAllDescription(PageRequest.of(page, nbPage));
        return ResponseEntity.ok(se);
    }

    @GetMapping(path = "/rechercherParSecteurActivite")
    public ResponseEntity<Response> rechercherParSecteurActivite(
        @RequestParam(name = "secteurActivite") SecteurActivite secteurActivite,
        @RequestParam(name = "page")int page,
        @RequestParam(name = "nbpage")int nbpage){
           var res = descriptionService.rechercherParSecteurActivite(secteurActivite, PageRequest.of(page, nbpage));
           return new ResponseEntity<Response>(new Response("secteurActivite Page", res),HttpStatus.OK);
    }
    
}
