package com.learn.springboottutorial.repository;

import com.learn.springboottutorial.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author anthonylee
 */
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
