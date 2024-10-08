package com.example.demo.hexagonal_architecture.core.service;
import com.example.demo.hexagonal_architecture.adapter.dto.LetterWordDTO;
import com.example.demo.hexagonal_architecture.adapter.mapper.LetterWordMapper;
import com.example.demo.hexagonal_architecture.adapter.mapperDto.LetterWordDTOMapper;
import com.example.demo.hexagonal_architecture.core.enitity.LetterWordEntity;
import com.example.demo.hexagonal_architecture.core.port.out.LetterWordRepository;
import com.example.demo.hexagonal_architecture.core.port.out.in.LetterWordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LetterWordServiceImpl implements LetterWordService {

    private final LetterWordMapper letterWordMapper;
    private final LetterWordDTOMapper letterWordDTOMapper;
    private final LetterWordRepository letterWordRepository;


    @Override
    public LetterWordDTO saveLetterWord(LetterWordDTO letterWordDTO) {
        LetterWordEntity letterWordEntity = letterWordRepository.saveLetterWord(letterWordMapper.apply(letterWordDTO));
        LetterWordDTO letterWordDTO1 = letterWordDTOMapper.apply(letterWordEntity);
        return letterWordDTO1;
    }

    @Override
    public List<LetterWordDTO> getAll() {
        List<LetterWordEntity> letterWordEntities = letterWordRepository.getAll();
        List<LetterWordDTO> letterWordDTO = letterWordEntities
                .stream()
                .map(lettersWords -> letterWordDTOMapper.apply(lettersWords)).collect(Collectors.toList());
        return letterWordDTO;
    }

    @Override
    public Optional<LetterWordDTO> findById(Long letterWordId) {
       Optional<LetterWordEntity> letterWordEntity = letterWordRepository.findById(letterWordId);
       Optional<LetterWordDTO> letterWordDTO = letterWordEntity.
               stream()
               .map(a -> letterWordDTOMapper.apply(a))
               .findFirst();
       return letterWordDTO;
    }

    public Optional<LetterWordDTO> findRandomLetterWordById() {
        List<LetterWordDTO> allLetterWords = getAll();

        if(allLetterWords.isEmpty()) {
         return Optional.empty();
        }

        int randomIndex = (int) (Math.random() * allLetterWords.size());
        return Optional.of(allLetterWords.get(randomIndex));
    }
}