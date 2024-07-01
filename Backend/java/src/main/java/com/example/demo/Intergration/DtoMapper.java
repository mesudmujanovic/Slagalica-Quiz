package com.example.demo.Intergration;

public interface DtoMapper <T, C>{
    public <T> T apply(C c);
}