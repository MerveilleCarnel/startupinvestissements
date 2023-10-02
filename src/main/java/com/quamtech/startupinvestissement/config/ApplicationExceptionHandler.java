package com.quamtech.startupinvestissement.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.quamtech.startupinvestissement.exception.ActionNotFoundExeption;
import com.quamtech.startupinvestissement.exception.DescriptionNotFoundException;
import com.quamtech.startupinvestissement.exception.InvestisseurNotFoudException;
import com.quamtech.startupinvestissement.exception.UserNotFoudException;

@RestControllerAdvice
public class ApplicationExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> gererLesArgumentInvalid(MethodArgumentNotValidException exception){
        Map<String, String> errorMap = new HashMap<>();
            exception.getBindingResult().getFieldErrors().forEach(erreur ->{
            errorMap.put(erreur.getField(), erreur.getDefaultMessage());
            });
        return errorMap;
    }    

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(IllegalArgumentException.class)
    public Map<String, String> ValeurNonConforme(IllegalArgumentException exception){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage",exception.getMessage());
        return errorMap;
     }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(InvestisseurNotFoudException.class)
    public Map<String, String> ValeurNonConforme(InvestisseurNotFoudException exception){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage",exception.getMessage());
        return errorMap;
     }
 
     @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ActionNotFoundExeption.class)
    public Map<String, String> ValeurNonConforme(ActionNotFoundExeption exception){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage",exception.getMessage());
        return errorMap;
     }
  

 @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UserNotFoudException.class)
    public Map<String, String> ValeurNonConforme(UserNotFoudException exception){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage",exception.getMessage());
        return errorMap;
     }



}
