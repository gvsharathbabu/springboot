package com.training.springboot.exceptions;

import com.training.springboot.dto.ExceptionFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UnableToProcessException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(UnableToProcessException ex, WebRequest request) {
        ExceptionFormat format = new ExceptionFormat(ex.getMessage(),
                request.getDescription(false), new Date());
        return new ResponseEntity<>(format, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionFormat format = new ExceptionFormat(ex.getBindingResult().getFieldError() != null
                ? ex.getBindingResult().getFieldError().getDefaultMessage()
                : ex.getBindingResult().toString(), "Validation Failed", new Date());
        return new ResponseEntity<>(format, HttpStatus.BAD_REQUEST);
    }
}
