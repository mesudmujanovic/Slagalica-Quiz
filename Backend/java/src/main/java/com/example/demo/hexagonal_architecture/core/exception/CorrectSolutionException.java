package com.example.demo.hexagonal_architecture.core.exception;

public class CorrectSolutionException extends SolutionException {
    public CorrectSolutionException() {
        super("The solution is correct.");
    }
}