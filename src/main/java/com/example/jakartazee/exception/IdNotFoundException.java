package com.example.jakartazee.exception;

import jakarta.ws.rs.WebApplicationException;

public class IdNotFoundException extends WebApplicationException {

    public IdNotFoundException() {
        super();
    }

    public IdNotFoundException(String message) {
        super(message);
    }

}
