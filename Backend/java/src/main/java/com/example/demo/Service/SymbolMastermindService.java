package com.example.demo.Service;

import com.example.demo.infrastucture.dto.SymbolMastermindDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface SymbolMastermindService {

    SymbolMastermindDTO createSymbolMastermind(SymbolMastermindDTO symbolMastermindDTO, MultipartFile multipartFile);
    List<SymbolMastermindDTO> getAllSymbolMastermind();
}
