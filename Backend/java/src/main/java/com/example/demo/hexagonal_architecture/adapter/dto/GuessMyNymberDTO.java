package com.example.demo.hexagonal_architecture.adapter.dto;

import com.example.demo.hexagonal_architecture.adapter.request.GuessMyNymberRequest;
import com.example.demo.hexagonal_architecture.adapter.response.GuessMyNymberResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuessMyNymberDTO {

    private Long id;
    private int number1;
    private int number2;
    private int number3;
    private int number4;
    private int number5;
    private int number6;
    private int result;

    public static GuessMyNymberDTO fromRequestToDto(GuessMyNymberRequest quizRequest){
        GuessMyNymberDTO quizDTO = new GuessMyNymberDTO();
        quizDTO.setResult(quizRequest.getResult());
        return quizDTO;
    }

    public GuessMyNymberResponse fromDtoToResponse(){
        GuessMyNymberResponse quizResponse = new GuessMyNymberResponse();
        quizResponse.setId(this.getId());
        quizResponse.setNumber1(this.getNumber1());
        quizResponse.setNumber2(this.getNumber2());
        quizResponse.setNumber3(this.getNumber3());
        quizResponse.setNumber4(this.getNumber4());
        quizResponse.setNumber5(this.getNumber5());
        quizResponse.setNumber6(this.getNumber6());
        quizResponse.setResult(this.getResult());
        return quizResponse;
    }
}
