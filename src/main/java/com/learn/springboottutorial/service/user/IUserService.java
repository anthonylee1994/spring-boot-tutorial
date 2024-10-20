package com.learn.springboottutorial.service.user;

import com.learn.springboottutorial.dto.UserDto;
import com.learn.springboottutorial.model.User;
import com.learn.springboottutorial.request.RegistrationRequest;
import com.learn.springboottutorial.request.UserUpdateRequest;

import java.util.List;

/**
 * @author anthonylee
 */
public interface IUserService {
    User register(RegistrationRequest request);

    User update(Long userId, UserUpdateRequest request);

    User findById(Long userId);

    void delete(Long userId);

    List<UserDto> getAllUsers();
}
