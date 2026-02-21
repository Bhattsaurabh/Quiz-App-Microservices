package com.sp.main.quiz_service.model;

import lombok.Data;

@Data
public class Response {

    //  THIS IS THE RESPONSE COMING FROM END USER FOR A PARTICULAR QUESTION

    private Long id;
    private String response;

}
