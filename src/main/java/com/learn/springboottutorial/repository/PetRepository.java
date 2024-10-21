package com.learn.springboottutorial.repository;

import com.learn.springboottutorial.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author anthonylee
 */
public interface PetRepository extends JpaRepository<Pet, Long> {
}
