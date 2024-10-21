package com.learn.springboottutorial.service.appointment;

import com.learn.springboottutorial.model.Appointment;
import com.learn.springboottutorial.request.AppointmentUpdateRequest;
import com.learn.springboottutorial.request.BookAppointmentRequest;

import java.util.List;

/**
 * @author anthonylee
 */
public interface IAppointmentService {
    Appointment createAppointment(BookAppointmentRequest request, Long senderId, Long recipientId);

    List<Appointment> getAllAppointments();

    Appointment updateAppointment(Long id, AppointmentUpdateRequest request);

    void deleteAppointment(Long id);

    Appointment getAppointmentById(Long id);

    Appointment getAppointmentByNo(String appointmentNo);
}
