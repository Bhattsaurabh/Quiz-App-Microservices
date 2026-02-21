package com.sp.main.quiz_service.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Quiz {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ElementCollection
    private List<Long>questionIds;



}
