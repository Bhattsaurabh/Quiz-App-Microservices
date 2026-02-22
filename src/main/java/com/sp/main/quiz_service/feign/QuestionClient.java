package com.sp.main.quiz_service.feign;

import com.sp.main.quiz_service.model.QuestionWrapper;
import com.sp.main.quiz_service.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

// THIS WILL CONNECT YOUR QUIZ SERVICE TO QUESTION SERVICE
// LOAD BALANCING IS DONE BY FEIGN
// WHICH INSTANCE OF QUESTION SERVICE WILL INVOKE DECIDED BY LOAD BALANCER
// HERE WE ARE INVOKING QUESTION SERVICE BY ITS NAME NOT URL OR (IP/PORT/URL BCZ IT MAY HAVE MULTIPLE INSTANCES )
// EUREKA SERVER IS USED TO DISCOVER THE SERVICE
@FeignClient("QUESTION-SERVICE")
public interface QuestionClient {


    @GetMapping("question/generate")
    public ResponseEntity<List<Long>> generateQuestionForQuiz(@RequestParam String category, @RequestParam Integer totalQuestions);

    @PostMapping("question/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsByIds(@RequestBody List<Long>questionsIds);

    @PostMapping("question/getScore")
    public ResponseEntity<Integer> calculateScore(@RequestBody List<Response> responses);



}
