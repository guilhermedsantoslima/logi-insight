package com.example.LogiInsight.rest.controller;

import com.example.LogiInsight.exception.CnpjAlreadyExistsException;
import com.example.LogiInsight.exception.InvalidLoginException;
import com.example.LogiInsight.exception.NotFoundUserException;
import com.example.LogiInsight.rest.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;
@RestControllerAdvice
public class AplicationControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleMethodValidNotException(MethodArgumentNotValidException ex){
        List<String> errors = ex.getBindingResult().getAllErrors()
                .stream()
                .map(e -> e.getDefaultMessage())
                .collect(Collectors.toList());

        return new ApiErrors(errors);
    }

    @ExceptionHandler(NotFoundUserException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrors handleNotFoundUserException(NotFoundUserException e){
        return new ApiErrors(e.getMessage());
    }

    @ExceptionHandler(InvalidLoginException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ApiErrors handleINvalidLoginException(InvalidLoginException e){
        return new ApiErrors(e.getMessage());
    }

    @ExceptionHandler(CnpjAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrors handleCnpjAlreadyExists(NotFoundUserException e){
        return new ApiErrors(e.getMessage());
    }
}
