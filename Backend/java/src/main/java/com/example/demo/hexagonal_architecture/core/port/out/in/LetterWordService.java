package com.example.demo.hexagonal_architecture.core.port.out.in;

import com.example.demo.hexagonal_architecture.adapter.dto.LetterWordDTO;
import java.util.List;

public interface LetterWordService {

    LetterWordDTO saveLetterWord (LetterWordDTO letterWordDTO);

    List<LetterWordDTO> getAll();
}
