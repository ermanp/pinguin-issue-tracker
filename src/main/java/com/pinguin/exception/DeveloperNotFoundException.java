package com.pinguin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class DeveloperNotFoundException extends Exception{

    public DeveloperNotFoundException() {
        super("Developer not found");
    }

}
