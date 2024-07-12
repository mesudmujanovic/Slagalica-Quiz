package com.example.demo.Service.Impl;
import com.example.demo.Enitity.SymbolMastermind;
import com.example.demo.Repo.SymbolMastermindRepository;
import com.example.demo.Service.SymbolMastermindService;
import com.example.demo.infrastucture.Mapper.SymbolMasterMindDTOMapper;
import com.example.demo.infrastucture.Mapper.SymbolMasterMindMapper;
import com.example.demo.infrastucture.dto.SymbolMastermindDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class SymbolMastermindServiceImpl implements SymbolMastermindService {

    private final SymbolMastermindRepository symbolMastermindRepository;
    private final SymbolMasterMindMapper symbolMastermindMapper;
    private final SymbolMasterMindDTOMapper symbolMastermindDTOMapper;

    @Override
    @Transactional
    public SymbolMastermindDTO createSymbolMastermind(SymbolMastermindDTO symbolMastermindDTO, MultipartFile multipartFile) {
        try {
            byte[] imageData = multipartFile.getBytes();
            SymbolMastermind symbolMastermind = symbolMastermindMapper.apply(symbolMastermindDTO);
            symbolMastermind.setImage(imageData);
            SymbolMastermind savedMastermind = symbolMastermindRepository.save(symbolMastermind);
            return symbolMastermindDTOMapper.apply(savedMastermind);
        } catch (IOException ioException) {
            log.error("Error while saving image for SymbolMastermind", ioException);
            throw new RuntimeException("Greška prilikom čuvanja slike", ioException);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<SymbolMastermindDTO> getAllSymbolMastermind() {
        return symbolMastermindRepository.findAll().stream()
                .map(symbolMastermindDTOMapper::apply)
                .collect(Collectors.toList());
    }
}