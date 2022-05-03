package com.freelanceapp.exception;

public class JobNotFoundException extends Exception{
    public JobNotFoundException() {
    }

    public JobNotFoundException(String message) {
        super(message);
    }
}
