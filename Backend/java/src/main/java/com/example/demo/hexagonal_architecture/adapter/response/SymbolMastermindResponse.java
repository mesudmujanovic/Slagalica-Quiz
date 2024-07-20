package com.example.demo.hexagonal_architecture.adapter.response;


import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SymbolMastermindResponse {

    private Long id;
    private String name;

    @Lob
    @Column(length = 1000000)
    private byte[] image;
}
