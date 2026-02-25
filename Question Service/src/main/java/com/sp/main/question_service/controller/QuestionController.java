package com.sp.main.question_service.controller;

import com.netflix.discovery.converters.Auto;
import com.sp.main.question_service.model.Question;
import com.sp.main.question_service.model.QuestionWrapper;
import com.sp.main.question_service.model.Response;
import com.sp.main.question_service.service.QuestionService;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private Environment environment;

    // ALWAYS USE POST-MAPPING WHEN YOU USE @REQUESTBODY
    // WITH GETMAPPING USE @REQUESTPARAM


    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question)
    {
        return questionService.addQuestion(question);
    }


    @PostMapping("get-Questions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionByIds(@RequestBody List<Long> questionIds)
    {
        //THIS IS FOR ONLY PRINTING THE PORT NO OF THE INSTANCE
        System.out.println(environment.getProperty("local.server.port"));

        return questionService.getQuestionsById(questionIds);
    }


    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions()
    {
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category)
    {
        return questionService.getQuestionByCategory(category);
    }


    @GetMapping("generate")
    public ResponseEntity<List<Long>> generateQuestionForQuiz(@RequestParam String category, @RequestParam Integer totalQuestions)
    {
        return questionService.getQuestionForQuiz(category, totalQuestions);
    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses)
    {
        return questionService.getScore(responses);
    }




}
