package com.example.demo.hexagonal_architecture.core.port.out.in;

import com.example.demo.hexagonal_architecture.adapter.dto.SymbolMastermindDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface SymbolMastermindService {

    SymbolMastermindDTO createSymbolMastermind(SymbolMastermindDTO symbolMastermindDTO, MultipartFile multipartFile);
    List<SymbolMastermindDTO> getAllSymbolMastermind();
}
