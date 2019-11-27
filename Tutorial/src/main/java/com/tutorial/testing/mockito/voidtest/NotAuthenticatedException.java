package com.tutorial.testing.mockito.voidtest;

public class NotAuthenticatedException extends Exception {
    
    public NotAuthenticatedException() {
        super("Could not authenticate!");
    }
}
