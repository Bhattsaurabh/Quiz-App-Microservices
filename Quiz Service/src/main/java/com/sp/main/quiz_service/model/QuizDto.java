package com.sp.main.quiz_service.model;

import lombok.Data;

@Data
public class QuizDto {

    // THIS WILL BE USED BY END USER TO CREATE A QUIZ

    private String category;
    private int totalQuestions;
    private String title;
}
