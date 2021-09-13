package com.example.demo.ErrorHandlers;

import com.example.demo.Dto.ErrorDto;
import com.example.demo.exceptions.NotAuthenticationException;
import com.example.demo.exceptions.SpringRedditException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;



@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler({SpringRedditException.class, NotAuthenticationException.class})
    protected ResponseEntity<Object> handleEntityNotFoundEx(RuntimeException ex, WebRequest request) {
        ErrorDto errorDto = new ErrorDto(ex.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }
}
