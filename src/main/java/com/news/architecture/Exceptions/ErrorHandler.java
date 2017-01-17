package com.news.architecture.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.support.RequestContext;

import javax.inject.Inject;


/**
 * Created by sukh on 2017-01-16.
 */

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(Throwable.class)
    protected ResponseEntity<Error> genericError(RuntimeException e){
        Error error = new Error();
        error.setErrorCode("001");
        error.setErrorMessage(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
