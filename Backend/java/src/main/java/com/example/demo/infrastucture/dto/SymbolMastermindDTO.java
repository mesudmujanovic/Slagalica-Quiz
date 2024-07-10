package com.example.demo.infrastucture.dto;
import com.example.demo.infrastucture.Request.SymbolMastermindRequest;
import com.example.demo.infrastucture.Response.SymbolMastermindResponse;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.IOException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SymbolMastermindDTO {

    private Long id;
    private String name;
    @Lob
    @Column(length = 1000000)
    private byte[] image;

    public static SymbolMastermindDTO toDto (SymbolMastermindRequest symbolMastermindRequest){
        SymbolMastermindDTO symbolMastermindDTO = new SymbolMastermindDTO();
        symbolMastermindDTO.setId(symbolMastermindRequest.getId());
        symbolMastermindDTO.setName(symbolMastermindRequest.getName());
        try {
            byte[] imageData = symbolMastermindRequest.getImage().getBytes();
            symbolMastermindDTO.setImage(imageData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return symbolMastermindDTO;
    }

    public static SymbolMastermindResponse toResponse(SymbolMastermindDTO symbolMastermindDTO) {
        SymbolMastermindResponse symbolMastermindResponse = new SymbolMastermindResponse();
        symbolMastermindResponse.setId(symbolMastermindDTO.getId());
        symbolMastermindResponse.setName(symbolMastermindDTO.getName());
        symbolMastermindResponse.setImage(symbolMastermindDTO.getImage());
        return symbolMastermindResponse;
    }
}
