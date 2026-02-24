package com.sp.main.quiz_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionWrapper {

    //  THIS CLASS WILL BE USE BY END USER TO SEE A QUESTION

    private Long id;

    private String questionTitle;

    private String option1;
    private String option2;
    private String option3;
    private String option4;
}
