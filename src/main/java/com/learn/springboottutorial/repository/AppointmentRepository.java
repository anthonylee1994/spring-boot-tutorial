package com.learn.springboottutorial.repository;

import com.learn.springboottutorial.enums.AppointmentStatus;
import com.learn.springboottutorial.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author anthonylee
 */
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Appointment findByAppointmentNo(String appointmentNo);

    boolean existsByVeterinarianIdAndPatientIdAndStatus(Long veterinarianId, Long reviewerId, AppointmentStatus appointmentStatus);
}
