package com.learn.springboottutorial.service.user;

import com.learn.springboottutorial.model.User;
import com.learn.springboottutorial.request.RegistrationRequest;
import org.springframework.stereotype.Service;

/**
 * @author anthonylee
 */

@Service
public class UserAttributesMapper {
    public void setCommonAttributes(RegistrationRequest source, User target) {
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setGender(source.getGender());
        target.setPhoneNumber(source.getPhoneNumber());
        target.setEmail(source.getEmail());
        target.setPassword(source.getPassword());
        target.setUserType(source.getUserType());
        target.setEnabled(source.isEnabled());
        target.setUserType(source.getUserType());
    }
}
