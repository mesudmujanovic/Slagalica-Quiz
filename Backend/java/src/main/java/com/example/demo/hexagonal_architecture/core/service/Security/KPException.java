package com.example.demo.hexagonal_architecture.core.service.Security;
import lombok.extern.java.Log;

@Log
public class KPException extends Exception{


    public KPException(String message) {
        super(message);
        log.info(message);
    }
}