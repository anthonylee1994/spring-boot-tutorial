package com.learn.springboottutorial.factory;

import com.learn.springboottutorial.model.Patient;
import com.learn.springboottutorial.model.User;
import com.learn.springboottutorial.repository.PatientRepository;
import com.learn.springboottutorial.request.RegistrationRequest;
import com.learn.springboottutorial.service.user.UserAttributesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author anthonylee
 */
@Service
@RequiredArgsConstructor
public class PatientFactory {
    private final PatientRepository patientRepository;
    private final UserAttributesMapper userAttributesMapper;

    public User createPatient(RegistrationRequest registrationRequest) {
        Patient patient = new Patient();
        userAttributesMapper.setCommonAttributes(registrationRequest, patient);
        return patientRepository.save(patient);
    }
}
