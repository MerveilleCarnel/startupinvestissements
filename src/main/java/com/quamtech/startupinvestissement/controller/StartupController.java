package com.quamtech.startupinvestissement.controller;

import java.io.IOException;
import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.springframework.web.multipart.MultipartFile;

import com.quamtech.startupinvestissement.Entity.Startup;
import com.quamtech.startupinvestissement.exception.IllegalArgumentException;
import com.quamtech.startupinvestissement.exception.StartupNotFoundException;
import com.quamtech.startupinvestissement.payloads.in.CreerStartupPayload;
import com.quamtech.startupinvestissement.payloads.in.UpdateStartupPayload;
import com.quamtech.startupinvestissement.services.StartupService;
import com.quamtech.startupinvestissement.utils.FileManager;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@OpenAPIDefinition
@CrossOrigin(origins="*")
public class StartupController {
    private final StartupService startupService;

    @PostMapping(path = "/startup")
    public ResponseEntity<Startup> creerStartup(@Valid @RequestBody CreerStartupPayload CreerSatrtupPayload){
        var p = startupService.CreerStartup(CreerSatrtupPayload);
        return new ResponseEntity<Startup>(p, HttpStatus.OK);
    }

     @GetMapping(path = "/getOneStatup")
    public ResponseEntity<Startup> getOneStartup(@RequestParam(name = "id")String id) throws StartupNotFoundException{
        return ResponseEntity.ok(startupService.getOneStartup(id));
    }

    @GetMapping(path = "/getAllStartup")
    public ResponseEntity<List<Startup>> getAllStartup(){
        var st = startupService.getAllStartup();
        return ResponseEntity.ok(st);
    }

     @PutMapping(path = "/update/{id}")
        public ResponseEntity<Startup> updateStartup(@RequestBody UpdateStartupPayload updateStartupPayload) throws StartupNotFoundException {
        return ResponseEntity.ok(startupService.updateStartup(updateStartupPayload));

    }

        @DeleteMapping(path="/deleteStartup/{id}")
        public ResponseEntity<HttpStatus> deleteStartupById(@PathVariable(name="id") String Id){
        startupService.removeStartupById(Id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED); 
    }


@PostMapping(value = "/internship/cv",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
public ResponseEntity<String> uploadFile(@RequestParam("file")MultipartFile file) throws IOException, IllegalArgumentException{
    return new ResponseEntity<>(FileManager.saveFile(file),HttpStatus.CREATED);
}

}
