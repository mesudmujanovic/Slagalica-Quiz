package com.example.demo.hexagonal_architecture.core.exception;

import com.example.demo.hexagonal_architecture.adapter.response.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CorrectSolutionException.class)
    public ResponseEntity<MessageResponse> handleCorrectSolutionException(CorrectSolutionException ex) {
        return ResponseEntity.ok(new MessageResponse(ex.getMessage()));
    }

    @ExceptionHandler(IncorrectSolutionException.class)
    public ResponseEntity<MessageResponse> handleIncorrectSolutionException(IncorrectSolutionException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse(ex.getMessage()));
    }

    @ExceptionHandler(UnexpectedErrorException.class)
    public ResponseEntity<MessageResponse> handleUnexpectedErrorException(UnexpectedErrorException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse(ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MessageResponse> handleGenericException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("An unexpected error occurred."));
    }
}