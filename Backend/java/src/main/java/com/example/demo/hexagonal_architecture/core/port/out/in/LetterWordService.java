package com.example.demo.hexagonal_architecture.core.port.out.in;

import com.example.demo.hexagonal_architecture.adapter.dto.LetterWordDTO;
import java.util.List;
import java.util.Optional;

public interface LetterWordService {
    LetterWordDTO saveLetterWord (LetterWordDTO letterWordDTO);

    List<LetterWordDTO> getAll();

    Optional<LetterWordDTO> findById(Long letterWordId);
}
