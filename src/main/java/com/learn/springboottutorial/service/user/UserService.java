package com.learn.springboottutorial.service.user;

import com.learn.springboottutorial.dto.EntityConverter;
import com.learn.springboottutorial.dto.UserDto;
import com.learn.springboottutorial.exception.ResourceNotFoundException;
import com.learn.springboottutorial.factory.UserFactory;
import com.learn.springboottutorial.model.User;
import com.learn.springboottutorial.repository.UserRepository;
import com.learn.springboottutorial.request.RegistrationRequest;
import com.learn.springboottutorial.request.UserUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author anthonylee
 */
@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final UserFactory userFactory;
    private final EntityConverter<User, UserDto> entityConverter;

    @Override
    public User register(RegistrationRequest request) {
        return userFactory.createUser(request);
    }

    @Override
    public User update(Long userId, UserUpdateRequest request) {
        User user = findById(userId);
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setGender(request.getGender());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setSpecialization(request.getSpecialization());
        return userRepository.save(user);
    }

    @Override
    public void delete(Long userId) {
        userRepository.findById(userId).ifPresentOrElse(userRepository::delete, () -> {
            throw new ResourceNotFoundException("User not found");
        });
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> entityConverter.mapEntityToDto(user, UserDto.class)).toList();
    }

    public User findById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}
