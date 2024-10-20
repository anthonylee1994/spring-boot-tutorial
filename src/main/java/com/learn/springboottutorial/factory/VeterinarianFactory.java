package com.learn.springboottutorial.factory;

import com.learn.springboottutorial.model.User;
import com.learn.springboottutorial.model.Veterinarian;
import com.learn.springboottutorial.repository.VeterinarianRepository;
import com.learn.springboottutorial.request.RegistrationRequest;
import com.learn.springboottutorial.service.user.UserAttributesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author anthonylee
 */
@Service
@RequiredArgsConstructor
public class VeterinarianFactory {
    private final VeterinarianRepository veterinarianRepository;
    private final UserAttributesMapper userAttributesMapper;

    public User createVeterinarian(RegistrationRequest request) {
        Veterinarian veterinarian = new Veterinarian();
        userAttributesMapper.setCommonAttributes(request, veterinarian);
        veterinarian.setSpecialization(request.getSpecialization());
        return veterinarianRepository.save(veterinarian);
    }
}
