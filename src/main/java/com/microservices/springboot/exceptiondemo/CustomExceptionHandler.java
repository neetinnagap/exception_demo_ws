package com.microservices.springboot.exceptiondemo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Calendar;

//@ControllerAdvice - To be used for exception handlers
//so that they work on all other regular controllers
@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<CustomErrorDetails> handleCustomException(CustomException exception, WebRequest request) {
        CustomErrorDetails error = new CustomErrorDetails(Calendar.getInstance().getTime(), exception.getMessage(), request.getDescription(false));
        ResponseEntity<CustomErrorDetails> response = new ResponseEntity(error, HttpStatus.NOT_FOUND);
        return response;
    }

    @ExceptionHandler
    public final ResponseEntity<CustomErrorDetails> handleOtherException(Exception exception, WebRequest request) {
        CustomErrorDetails error = new CustomErrorDetails(Calendar.getInstance().getTime(), exception.getMessage(), request.getDescription(false));
        ResponseEntity<CustomErrorDetails> response = new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        return response;
    }

}
