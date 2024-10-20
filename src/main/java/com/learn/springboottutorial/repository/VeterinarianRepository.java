package com.learn.springboottutorial.repository;

import com.learn.springboottutorial.model.Veterinarian;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author anthonylee
 */
public interface VeterinarianRepository extends JpaRepository<Veterinarian, Long> {
}
