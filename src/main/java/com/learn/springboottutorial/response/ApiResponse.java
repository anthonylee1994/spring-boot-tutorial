package com.learn.springboottutorial.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author anthonylee
 */
@Data
@AllArgsConstructor
public class ApiResponse {
    private String message;
    private Object data;
}
