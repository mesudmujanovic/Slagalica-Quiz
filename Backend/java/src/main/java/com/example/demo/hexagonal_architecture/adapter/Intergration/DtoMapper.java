package com.example.demo.hexagonal_architecture.adapter.Intergration;

public interface DtoMapper <T, C>{
    public <T> T apply(C c);
}