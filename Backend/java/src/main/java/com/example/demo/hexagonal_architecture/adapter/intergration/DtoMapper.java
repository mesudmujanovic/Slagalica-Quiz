package com.example.demo.hexagonal_architecture.adapter.intergration;

public interface DtoMapper <T, C>{
    public <T> T apply(C c);
}