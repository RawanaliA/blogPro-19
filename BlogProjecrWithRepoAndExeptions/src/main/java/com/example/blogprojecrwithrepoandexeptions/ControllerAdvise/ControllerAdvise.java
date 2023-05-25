package com.example.blogprojecrwithrepoandexeptions.ControllerAdvise;

import com.example.blogprojecrwithrepoandexeptions.ApiExeption.ApiExeption;
import com.example.blogprojecrwithrepoandexeptions.ApiResponce.ApiResponce;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvise {
    @ExceptionHandler(value = ApiExeption.class)
    public ResponseEntity<ApiResponce>ApiExeption(ApiExeption e){
        String message= e.getMessage();
        return ResponseEntity.status(400).body(new ApiResponce (message));
    }
    //
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiResponce>DataIntegrityViolationException(DataIntegrityViolationException e) {
        String message = e.getMessage();
        return ResponseEntity.status(400).body(new ApiResponce(message));
    }

}
