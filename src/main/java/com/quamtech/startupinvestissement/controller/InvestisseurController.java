package com.quamtech.startupinvestissement.controller;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

import com.quamtech.startupinvestissement.Entity.Investisseur;

import com.quamtech.startupinvestissement.exception.InvestisseurNotFoudException;
import com.quamtech.startupinvestissement.payloads.in.CreerInvestissseurPayload;
import com.quamtech.startupinvestissement.payloads.in.UpdateInvestisseurPayload;
import com.quamtech.startupinvestissement.services.InvestisseurService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import java.util.List;

@AllArgsConstructor
@RestController
@OpenAPIDefinition
@CrossOrigin(origins="*")

public class InvestisseurController {
    private final InvestisseurService investisseurService;

    @PostMapping(path = "/creerinvestisseur")
    public ResponseEntity<Investisseur> creerInvestisseur(@Valid @RequestBody CreerInvestissseurPayload creerInvestissseurpayload){
        var u = investisseurService.creerInvestisseur(creerInvestissseurpayload);
        return new ResponseEntity<Investisseur>(u, HttpStatus.OK);
    }
        /*@GetMapping(path = "/lireinvestisseur")
        public ResponseEntity<List<Investisseur>> getAllInvestisseur(){
        return new ResponseEntity<List<Investisseur>> (investisseurService.getAllInvestisseur(),HttpStatus.OK);
    }*/

        @PutMapping(path = "/updae/{id}")
        public ResponseEntity<Investisseur> updateInvestisseur(@RequestBody UpdateInvestisseurPayload updateInvestisseurPayload) throws InvestisseurNotFoudException {
            return ResponseEntity.ok(investisseurService.updateInvestisseur(updateInvestisseurPayload));

    }
    
      @DeleteMapping(path="/deleteInvestisseur/{id}")
        public ResponseEntity<HttpStatus> deleteInvestisseurById(@PathVariable(name = "id") String id){
        investisseurService.removeInvestisseurById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED); 
    }

       

    @GetMapping(path = "/getOneInvestisseur")
    public ResponseEntity<Investisseur> getOneInvestisseur(@RequestParam(name = "id")String id) throws InvestisseurNotFoudException {
        return ResponseEntity.ok(investisseurService.getOneInvestisseur(id));
    }

    @GetMapping(path = "/getAllInvestisseur")
    public ResponseEntity<List<Investisseur>> getAllInvestisseur(){
        var res = investisseurService.getAllInvestisseur();
        return ResponseEntity.ok(res);
    }

}