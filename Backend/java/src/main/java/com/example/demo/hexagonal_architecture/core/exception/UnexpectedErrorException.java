package com.example.demo.hexagonal_architecture.core.exception;

public class UnexpectedErrorException extends RuntimeException {
    public UnexpectedErrorException() {
        super("An unexpected error occurred.");
    }
}