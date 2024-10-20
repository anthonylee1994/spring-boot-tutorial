package com.learn.springboottutorial.request;

import lombok.Data;

/**
 * @author anthonylee
 */
@Data
public class UserUpdateRequest {
    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;
    private String specialization;
}
