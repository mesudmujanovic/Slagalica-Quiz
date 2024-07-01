package com.example.demo.infrastucture.dto;

import com.example.demo.infrastucture.Request.QuizMyNumberRequest;
import com.example.demo.infrastucture.Response.QuizMyNumberResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizMyNumberDTO {

    private Long id;
    private int number1;
    private int number2;
    private int number3;
    private int number4;
    private int number5;
    private int number6;
    private int result;

    public static QuizMyNumberDTO fromRequestToDto(QuizMyNumberRequest quizRequest){
        QuizMyNumberDTO quizDTO = new QuizMyNumberDTO();
        quizDTO.setResult(quizRequest.getResult());
        return quizDTO;
    }

    public QuizMyNumberResponse fromDtoToResponse(){
        QuizMyNumberResponse quizResponse = new QuizMyNumberResponse();
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
