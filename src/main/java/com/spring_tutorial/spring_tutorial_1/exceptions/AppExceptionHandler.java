package com.spring_tutorial.spring_tutorial_1.exceptions;

import com.spring_tutorial.spring_tutorial_1.data.resources.Error;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Obbiettivo: implementare dei metodi che catturino e gestiscano le eccezioni lanciate nell’applicazione
@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler({ ConstraintViolationException.class })
    protected ResponseEntity<Object> handleConstraintViolationException(
            ConstraintViolationException ex,
            WebRequest request) {
        List<Error> errors = ex.getConstraintViolations()
                .stream()
                .map(constraintViolation -> new Error(ex.getClass().getSimpleName(), constraintViolation.getMessage()))
                .collect(Collectors.toList());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ MethodArgumentNotValidException.class })
    protected ResponseEntity<Object> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex,
            WebRequest request) {
        List<Error> errors = ex.getBindingResult().getAllErrors()
                .stream()
                .map(error -> new Error(error.getClass().getSimpleName(), error.getDefaultMessage()))
                .collect(Collectors.toList());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ Exception.class })
    protected ResponseEntity<Object> handleAll(
            Exception ex,
            WebRequest request
    ) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Error error = new Error(
                ex.getClass().getSimpleName(),
                ex.getMessage()
        );
        return new ResponseEntity<>(Arrays.asList(error), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
