package com.irfaan.taxcalculation.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class TaxAppException extends Exception {

    private final HttpStatus status;

    public TaxAppException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

}
