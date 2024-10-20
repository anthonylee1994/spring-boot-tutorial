package com.learn.springboottutorial.repository;

import com.learn.springboottutorial.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author anthonylee
 */
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
