package com.example.demo.Service.Impl;

import com.example.demo.Enitity.SymbolMastermind;
import com.example.demo.Repo.SymbolMastermindRepository;
import com.example.demo.Service.SymbolMastermindService;
import com.example.demo.infrastucture.Mapper.SymbolMasterMindDTOMapper;
import com.example.demo.infrastucture.Mapper.SymbolMasterMindMapper;
import com.example.demo.infrastucture.dto.SymbolMastermindDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SymbolMastermindServiceImpl implements SymbolMastermindService {

    private final SymbolMastermindRepository symbolMastermindRepository;

    public SymbolMastermindServiceImpl(SymbolMastermindRepository symbolMastermindRepository) {
        this.symbolMastermindRepository = symbolMastermindRepository;
    }

    @Override
    public SymbolMastermindDTO createSymbolMastermind(SymbolMastermindDTO symbolMastermindDTO, MultipartFile multipartFile) {
        SymbolMastermind symbolMastermind1 = SymbolMasterMindMapper.INSTANCE.apply(symbolMastermindDTO);
        try {
         byte[] imageData = multipartFile.getBytes();
         symbolMastermind1.setImage(imageData);
         SymbolMastermind symbolMastermind = symbolMastermindRepository.save(symbolMastermind1);
         return SymbolMasterMindDTOMapper.INSTANCE.apply(symbolMastermind);
        } catch (IOException ioException) {
            ioException.printStackTrace();
            throw new RuntimeException("Greška prilikom čitanja slike", ioException);
        }
    }

    @Override
    public List<SymbolMastermindDTO> getAllSymbolMastermind() {
        return symbolMastermindRepository.findAll().stream()
                .map(symbol -> SymbolMasterMindDTOMapper.INSTANCE.apply(symbol))
                .collect(Collectors.toList());
    }
}
