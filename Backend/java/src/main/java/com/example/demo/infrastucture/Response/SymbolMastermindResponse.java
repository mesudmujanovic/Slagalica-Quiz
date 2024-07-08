package com.example.demo.infrastucture.Response;


import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

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
