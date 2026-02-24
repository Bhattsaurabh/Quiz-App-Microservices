package com.sp.main.question_service.repository;

import com.sp.main.question_service.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByCategory(String category);

    @Query("SELECT q.id FROM question q WHERE q.category=:category ORDER BY RAND() LIMIT :totalQuestions")
    List<Long> findRandomQuestion(String category, Integer totalQuestions);

}
