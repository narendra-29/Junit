package com.javacodegeeks.mockitotutorial.voidmethod;

public class NotAuthenticatedException extends Exception {
    
    public NotAuthenticatedException() {
        super("Could not authenticate!");
    }
}
