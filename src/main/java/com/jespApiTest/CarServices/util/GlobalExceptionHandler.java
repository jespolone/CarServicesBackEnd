package com.jespApiTest.CarServices.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.jespApiTest.CarServices.exception.InternalServerErrorException;
import com.jespApiTest.CarServices.exception.NotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class, InternalServerErrorException.class})
    public void handlerExcetion(HttpServletRequest request, Exception ex){
        log.warn("Call to {}({}) threw {}",ex.getClass().toString(), request.getRequestURL(), ex);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NotFoundException.class}) 
    public void handlerNotFoundExcetion(HttpServletRequest request, Exception ex){
        log.warn("Call to {}({}) threw {}",ex.getClass().toString(), request.getRequestURL(), ex);
    }

}
