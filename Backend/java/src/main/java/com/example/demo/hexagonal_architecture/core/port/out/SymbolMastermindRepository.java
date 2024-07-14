package com.example.demo.hexagonal_architecture.core.port.out;

import com.example.demo.hexagonal_architecture.core.Enitity.SymbolMastermind;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface SymbolMastermindRepository {
    SymbolMastermind createSymbolMastermind(SymbolMastermind symbolMastermind, MultipartFile multipartFile);
    List<SymbolMastermind> getAllSymbolMastermind();
}
