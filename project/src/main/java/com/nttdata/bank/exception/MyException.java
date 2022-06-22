package com.nttdata.bank.exception;


import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Getter
@Setter

public class MyException extends ResponseStatusException {
    private String message;

    public MyException(HttpStatus status) {

        super(status);
    }
    public MyException(HttpStatus status, String message) {
        super(status);
        this.message= message;
    }


}
