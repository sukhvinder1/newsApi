package com.news.architecture.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by sukh on 2017-01-16.
 * Generic class to handle all the error thrown in or after controller
 */
@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(Throwable.class)
    protected ResponseEntity<Error> genericError(RuntimeException e){
        Error error = new Error();
        error.setErrorCode("001");
        error.setErrorMessage(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
