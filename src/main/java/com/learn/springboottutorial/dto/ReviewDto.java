package com.learn.springboottutorial.dto;

import lombok.Data;

/**
 * @author anthonylee
 */
@Data
public class ReviewDto {
    private Long id;
    private String stars;
    private String feedback;
}

