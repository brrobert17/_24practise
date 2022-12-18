package com.example._24practise.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class CarNotAvailableException extends Throwable{
    public CarNotAvailableException(String message){
        super(message);
    }
}
