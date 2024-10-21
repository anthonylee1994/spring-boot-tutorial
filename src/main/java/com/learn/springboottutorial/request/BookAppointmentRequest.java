package com.learn.springboottutorial.request;

import com.learn.springboottutorial.model.Appointment;
import com.learn.springboottutorial.model.Pet;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author anthonylee
 */
@Getter
@Setter
public class BookAppointmentRequest {
    private Appointment appointment;
    private List<Pet> pets;
}
