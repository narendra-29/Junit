package com.javacodegeeks.mockitotutorial.basecode;

public class EmptyCredentialsException extends Exception {
    
    public EmptyCredentialsException() {
        super("Empty credentials!");
    }
}
