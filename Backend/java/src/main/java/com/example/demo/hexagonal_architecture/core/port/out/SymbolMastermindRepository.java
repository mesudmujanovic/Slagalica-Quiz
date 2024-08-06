package com.example.demo.hexagonal_architecture.core.port.out;

import com.example.demo.hexagonal_architecture.core.enitity.SymbolMastermindEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface SymbolMastermindRepository {
    SymbolMastermindEntity createSymbolMastermind(SymbolMastermindEntity symbolMastermindEntity, MultipartFile multipartFile);
    List<SymbolMastermindEntity> getAllSymbolMastermind();
}
