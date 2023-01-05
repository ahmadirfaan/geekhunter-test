package com.irfaan.taxcalculation.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class TaxAppException extends Exception {

    private HttpStatus status;

    public TaxAppException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

}
