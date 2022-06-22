package com.nttdata.bank.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ExceptionHandlers extends ResponseEntityExceptionHandler {

    private ApiExceptionResponse build(MyException apiException, WebRequest webRequest) {
        return ApiExceptionResponse.builder().date(new Date()).errorMessage(apiException.getMessage())
                .path(webRequest.getDescription(false))
                .build();
    }

    @ExceptionHandler(MyException.class)
    public final ResponseEntity<ApiExceptionResponse> errorHandler(MyException apiException, WebRequest webRequest) {
        return new ResponseEntity<>(build(apiException, webRequest), apiException.getStatus());
    }

}
