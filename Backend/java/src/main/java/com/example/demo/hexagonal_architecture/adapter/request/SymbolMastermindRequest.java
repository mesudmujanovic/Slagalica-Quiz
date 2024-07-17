package com.example.demo.hexagonal_architecture.adapter.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SymbolMastermindRequest {
    private Long id;
    private String name;
    private MultipartFile image;
}
