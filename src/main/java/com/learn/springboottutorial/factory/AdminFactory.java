package com.learn.springboottutorial.factory;

import com.learn.springboottutorial.model.Admin;
import com.learn.springboottutorial.model.User;
import com.learn.springboottutorial.repository.AdminRepository;
import com.learn.springboottutorial.request.RegistrationRequest;
import com.learn.springboottutorial.service.user.UserAttributesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author anthonylee
 */
@Service
@RequiredArgsConstructor
public class AdminFactory {
    private final AdminRepository adminRepository;
    private final UserAttributesMapper userAttributesMapper;

    public User createAdmin(RegistrationRequest registrationRequest) {
        Admin admin = new Admin();
        userAttributesMapper.setCommonAttributes(registrationRequest, admin);
        return adminRepository.save(admin);
    }
}
