package com.learn.springboottutorial.factory;

import com.learn.springboottutorial.model.User;
import com.learn.springboottutorial.request.RegistrationRequest;

/**
 * @author anthonylee
 */
public interface UserFactory {
    User createUser(RegistrationRequest registrationRequest);
}
