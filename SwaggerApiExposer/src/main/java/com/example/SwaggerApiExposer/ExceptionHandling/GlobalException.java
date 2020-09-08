package com.example.SwaggerApiExposer.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

/*
 * The GlobalException handles exception specific and global exception in a single place.
 * Uses the Error class to define a new error, according to the exception, and returns
 * as a ResponseEntity
 */
@ControllerAdvice
public class GlobalException extends Throwable {
    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<?> itemNotFoundException(ItemNotFoundException exception, WebRequest webRequest) {
        Error error = new Error(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NegativeQuantityException.class)
    public ResponseEntity<?> negativeWindrawException(NegativeQuantityException exception, WebRequest webRequest) {
        Error error = new Error(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(ItemExistsException.class)
    public ResponseEntity<?> itemExistsException(ItemExistsException exception, WebRequest webRequest) {
        Error error = new Error(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
    }
}
