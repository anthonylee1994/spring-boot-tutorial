package com.learn.springboottutorial.request;

import lombok.Data;

@Data
public class ReviewUpdateRequest {
    private int stars;
    private String feedback;
}
