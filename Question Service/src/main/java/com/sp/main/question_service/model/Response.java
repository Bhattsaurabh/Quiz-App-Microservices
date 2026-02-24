package com.sp.main.question_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    //THIS IS THE RESPONSE FROM END USER

    private Long id;
    private String response;


}
