package com.learn.springboottutorial.request;

import jakarta.persistence.Column;
import lombok.Data;

/**
 * @author anthonylee
 */
@Data
public class RegistrationRequest {
    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;
    private String email;
    private String password;
    private String userType;
    private boolean isEnabled;
    private String specialization;
}