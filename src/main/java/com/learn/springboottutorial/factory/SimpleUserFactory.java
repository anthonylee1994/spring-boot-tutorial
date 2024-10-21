package com.learn.springboottutorial.factory;

import com.learn.springboottutorial.exception.UserAlreadyExistsException;
import com.learn.springboottutorial.model.User;
import com.learn.springboottutorial.repository.UserRepository;
import com.learn.springboottutorial.request.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author anthonylee
 */
@Service
@RequiredArgsConstructor
public class SimpleUserFactory implements UserFactory {
    private final UserRepository userRepository;
    private final VeterinarianFactory veterinarianFactory;
    private final PatientFactory patientFactory;
    private final AdminFactory adminFactory;

    @Override
    public User createUser(RegistrationRequest registrationRequest) {
        if (userRepository.existsByEmail(registrationRequest.getEmail())) {
            throw new UserAlreadyExistsException("Oops! " + registrationRequest.getEmail() + "already exists.");
        }

        return switch (registrationRequest.getUserType()) {
            case "VET" -> veterinarianFactory.createVeterinarian(registrationRequest);
            case "PATIENT" -> patientFactory.createPatient(registrationRequest);
            case "ADMIN" -> adminFactory.createAdmin(registrationRequest);
            default -> null;
        };
    }
}
