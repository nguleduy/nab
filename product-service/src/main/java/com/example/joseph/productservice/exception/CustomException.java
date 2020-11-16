package com.example.joseph.productservice.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@ControllerAdvice
public class CustomException extends ResponseEntityExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<Object> handleResourceNotFound(Exception ex,
                                                       WebRequest request) {
    Error error = new Error(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
    error.setTimestamp(LocalDateTime.now());
    error.setMessage(ex.getMessage());
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(NoSuchElementException.class)
  public ResponseEntity<?> handleNoSuchElement(NoSuchElementException exception, WebRequest request) {
    Error error = new Error(LocalDateTime.now(), exception.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(error, HttpStatus.NO_CONTENT);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                HttpHeaders headers, HttpStatus status, WebRequest request) {
    Error error = new Error(LocalDateTime.now(), "Argument Not Valid", ex.getBindingResult().toString());
    return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
  }

}
