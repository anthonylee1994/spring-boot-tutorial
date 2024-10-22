package com.learn.springboottutorial.service.pet;

import com.learn.springboottutorial.exception.ResourceNotFoundException;
import com.learn.springboottutorial.model.Pet;
import com.learn.springboottutorial.repository.PetRepository;
import com.learn.springboottutorial.utils.FeedBackMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author anthonylee
 */
@RequiredArgsConstructor
@Service
public class PetService implements IPetService {
    private final PetRepository petRepository;

    @Override
    public List<Pet> savePetsForAppointment(List<Pet> pets) {
        return petRepository.saveAll(pets);
    }

    @Override
    public Pet updatePet(Pet pet, Long id) {
        Pet existingPet = getPetById(id);
        existingPet.setName(pet.getName());
        existingPet.setType(pet.getType());
        existingPet.setColor(pet.getColor());
        existingPet.setBreed(pet.getBreed());
        existingPet.setAge(pet.getAge());
        return petRepository.save(existingPet);
    }

    @Override
    public void deletePet(Long id) {
        petRepository.findById(id).ifPresentOrElse(petRepository::delete, () -> {
            throw new ResourceNotFoundException(FeedBackMessage.RESOURCE_NOT_FOUND);
        });
    }

    @Override
    public Pet getPetById(Long id) {
        return petRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(FeedBackMessage.RESOURCE_NOT_FOUND));
    }
}
