package com.kalamba.warmup.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class EmptyActionException extends Exception {
    public EmptyActionException(String message) { super(message); }
}
