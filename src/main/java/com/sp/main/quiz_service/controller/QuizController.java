package com.sp.main.quiz_service.controller;


import com.sp.main.quiz_service.model.QuestionWrapper;
import com.sp.main.quiz_service.model.QuizDto;
import com.sp.main.quiz_service.model.Response;
import com.sp.main.quiz_service.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;


    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto)
    {
        return quizService.createQuiz(quizDto.getCategory(), quizDto.getTotalQuestions(), quizDto.getTitle());
    }

    @GetMapping("get/{quizId}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Long quizId)
    {
        return quizService.getQuizQuestions(quizId);
    }

    @PostMapping("submit/{quizId}")
    public ResponseEntity<Integer> getScore(@PathVariable Long quizId, @RequestBody List<Response>responses)
    {
        return quizService.getScore(quizId, responses);
    }

}
