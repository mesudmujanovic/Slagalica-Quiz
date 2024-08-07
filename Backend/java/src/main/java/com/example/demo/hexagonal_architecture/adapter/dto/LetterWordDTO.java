package com.example.demo.hexagonal_architecture.adapter.dto;

import com.example.demo.hexagonal_architecture.adapter.request.LetterWordRequest;
import com.example.demo.hexagonal_architecture.adapter.response.LetterWordResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class LetterWordDTO {

    private Long id;
    private List<String> letters;
    private List<String> words;

    public static LetterWordDTO fromRequestToDTO(LetterWordRequest letterWordRequest){
        LetterWordDTO letterWordDTO = new LetterWordDTO();
        letterWordDTO.setId(letterWordRequest.getId());
        letterWordDTO.setWords(letterWordRequest.getWords());
        letterWordDTO.setLetters(letterWordRequest.getLetters());
        return letterWordDTO;
    }

    public static LetterWordResponse fromDTOToResponse(LetterWordDTO letterWordDTO){
        LetterWordResponse letterWordResponse = new LetterWordResponse();
        letterWordResponse.setId(letterWordDTO.getId());
        letterWordResponse.setWords(letterWordDTO.getWords());
        letterWordResponse.setLetters(letterWordDTO.getLetters());
        return letterWordResponse;
    }
}
