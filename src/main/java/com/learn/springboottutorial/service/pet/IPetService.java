package com.learn.springboottutorial.service.pet;

import com.learn.springboottutorial.model.Pet;

import java.util.List;

/**
 * @author anthonylee
 */
public interface IPetService {
    List<Pet> savePetsForAppointment(List<Pet> pets);

    Pet updatePet(Pet pet, Long id);

    void deletePet(Long id);

    Pet getPetById(Long id);
}
