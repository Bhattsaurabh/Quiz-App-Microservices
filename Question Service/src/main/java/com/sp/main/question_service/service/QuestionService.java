package com.sp.main.question_service.service;
import com.sp.main.question_service.model.Question;
import com.sp.main.question_service.model.QuestionWrapper;
import com.sp.main.question_service.model.Response;
import com.sp.main.question_service.repository.QuestionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private QuestionRepository questionRespository;


    public ResponseEntity<String> addQuestion(Question question)
    {
        questionRespository.save(question);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<Question>> getAllQuestions()
    {
        try {
            return new ResponseEntity<>(questionRespository.findAll(), HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<List<Question>> getQuestionByCategory(String category)
    {
        try {
            return new ResponseEntity<>(questionRespository.findByCategory(category), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<List<Long>> getQuestionForQuiz(String category, Integer totalQuestions)
    {
        return new ResponseEntity<>(questionRespository.findRandomQuestion(category, totalQuestions), HttpStatus.OK);
    }


    public ResponseEntity<List<QuestionWrapper>> getQuestionsById(List<Long> questionsIds)
    {
        List<QuestionWrapper> questionWrappers = questionsIds.stream()
                .map(id->{
                    Question question = questionRespository.findById(id).orElseThrow();
                    return modelMapper.map(question, QuestionWrapper.class);
                }).toList();

        return new ResponseEntity<>(questionWrappers, HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<Response> responses)
    {
            Integer score = responses.stream()
                    .mapToInt(response->{
                        Question question = questionRespository.findById(response.getId()).orElseThrow();
                        return question.getRightAnswer().equals(response.getResponse()) ? 1 : 0;
                    })
                    .sum();
            return new ResponseEntity<>(score, HttpStatus.OK);
    }





}
