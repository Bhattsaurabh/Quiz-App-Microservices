package com.sp.main.question_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionWrapper {

    // THIS CLASS IS GOING TO RETURN TO QUIZ SERVICE FOR END USER

    private Long Id;

    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

}
