package com.quamtech.startupinvestissement.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.quamtech.startupinvestissement.exception.IllegalArgumentException;

public class FileManager {
    public static String saveFile(MultipartFile file) throws IOException, IllegalArgumentException{
        if(file.isEmpty()){
            throw new IllegalArgumentException( "le fichier est vide");
        }
        // recuperer le chemin absolu du dossier de destination

        String dossierDestination ="uploads/"+file.getOriginalFilename();
        File convertedFile = new File (dossierDestination);
        try (FileOutputStream fileOutputStream= new FileOutputStream(convertedFile)){
            fileOutputStream.write(file.getBytes());
        }
// afficher un message de succés

return "le fichier a été enrégistré  avec succés dans le dossier: "+ dossierDestination;

        }
}
