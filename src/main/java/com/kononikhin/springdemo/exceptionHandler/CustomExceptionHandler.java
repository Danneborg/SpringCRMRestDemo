package com.kononikhin.springdemo.exceptionHandler;

import com.kononikhin.springdemo.customException.CustomErrorResponse;
import com.kononikhin.springdemo.customException.CustomNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    //Student not found by id
    @ExceptionHandler
    public ResponseEntity<CustomErrorResponse> handleException(CustomNotFoundException exc) {
        CustomErrorResponse response =
                new CustomErrorResponse(HttpStatus.NOT_FOUND.value(), exc.getMessage(), System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }

    //another handler
    @ExceptionHandler
    public ResponseEntity<CustomErrorResponse> handleException(Exception exc) {
        CustomErrorResponse response =
                new CustomErrorResponse(HttpStatus.BAD_REQUEST.value(), exc.getMessage(), System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
