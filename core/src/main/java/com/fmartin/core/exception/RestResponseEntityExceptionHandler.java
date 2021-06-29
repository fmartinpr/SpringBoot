package com.fmartin.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fmartin.core.dto.ErrorDto;

@ControllerAdvice
public class RestResponseEntityExceptionHandler 
  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { 
    		IllegalArgumentException.class, 
    		IllegalStateException.class
    })
    protected ResponseEntity<ErrorDto> handleConflict(
      RuntimeException ex, WebRequest request) {
    	String bodyOfResponse = "This should be application specific";
        return new ResponseEntity<>(new ErrorDto(bodyOfResponse), HttpStatus.CONFLICT);
    }
    
    @ExceptionHandler(value = {CoreException.class})
    protected ResponseEntity<ErrorDto> handleConfrictCore(
    		RuntimeException ex, WebRequest request) {
        return new ResponseEntity<>(new ErrorDto(ex.getMessage()), 
        		HttpStatus.BAD_REQUEST);
    }
}
