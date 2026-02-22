package com.sp.main.quiz_service.service;

import com.sp.main.quiz_service.feign.QuestionClient;
import com.sp.main.quiz_service.model.QuestionWrapper;
import com.sp.main.quiz_service.model.Quiz;
import com.sp.main.quiz_service.model.Response;
import com.sp.main.quiz_service.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {


    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionClient questionClient;


    public ResponseEntity<String> createQuiz(String category, Integer totalQuestions, String title)
    {

        List<Long>questionIds = questionClient.generateQuestionForQuiz(category,totalQuestions).getBody();

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questionIds);
        quizRepository.save(quiz);

        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }


    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Long quizId)
    {
        Quiz quiz = quizRepository.findById(quizId).get();
        List<Long>questionIds = quiz.getQuestionIds();
        return questionClient.getQuestionsByIds(questionIds);
    }

    public ResponseEntity<Integer> getScore(Long quizId, List<Response> responses)
    {
       if(quizRepository.existsById(quizId))
       {
           return questionClient.calculateScore(responses);
       }else {
           throw new RuntimeException("Quiz not exist");
       }
    }



}
