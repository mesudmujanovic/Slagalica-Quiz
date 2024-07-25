package com.example.demo.hexagonal_architecture.core.exception;

public class IncorrectSolutionException extends SolutionException {
    public IncorrectSolutionException() {
        super("The solution is incorrect.");
    }
}