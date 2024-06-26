package com.omerfaruksen.vetSystem.service;


import com.omerfaruksen.vetSystem.dto.request.AnimalRequestDto;
import com.omerfaruksen.vetSystem.entity.Animal;
import com.omerfaruksen.vetSystem.repository.AnimalRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnimalService {

    private final AnimalRepository animalRepository;
    private final ModelMapper modelMapper;

    public List<Animal> findAllAnimals (){
        return animalRepository.findAll();
    }

    public Animal findAnimalById (Long id){
        return animalRepository.findById(id).orElseThrow(() -> new RuntimeException("id:" + id + " animal could not found!!!"));
    }
    public List<Animal> findAnimalsByName(String name) {
        return animalRepository.findByNameContaining(name);
    }
    public List<Animal> findAnimalsByCustomer(Long id) {
        return animalRepository.findByCustomerId(id);
    }

    public Animal createAnimal(AnimalRequestDto animalRequestDto){
        Optional<Animal> existAnimalWithSameSpecs = animalRepository.findByNameAndSpeciesAndGenderAndDateOfBirth(animalRequestDto.getName(),animalRequestDto.getSpecies(),animalRequestDto.getGender(),animalRequestDto.getDateOfBirth());

        if (existAnimalWithSameSpecs.isPresent()){
            throw new RuntimeException("The animal has already been saved.");
        }
        Animal newAnimal = modelMapper.map(animalRequestDto, Animal.class);
        return animalRepository.save(newAnimal);
    }

    public Animal updateAnimal (Long id, AnimalRequestDto animalRequestDto){
        Optional<Animal> animalFromDb = animalRepository.findById(id);
        Optional<Animal> existOtherAnimalFromRequest = animalRepository.findByNameAndSpeciesAndGenderAndDateOfBirth(animalRequestDto.getName(),animalRequestDto.getSpecies(),animalRequestDto.getGender(),animalRequestDto.getDateOfBirth());

        if (animalFromDb.isEmpty()){
            throw new RuntimeException("id:" + id + "Customer could not found!!!");
        }

        if (existOtherAnimalFromRequest.isPresent() && !existOtherAnimalFromRequest.get().getId().equals(id)){
            throw new RuntimeException("This Customer has already been registered. That's why this request causes duplicate data");
        }

        Animal updatedAnimal = animalFromDb.get();
        modelMapper.map(animalRequestDto, updatedAnimal);
        return animalRepository.save(updatedAnimal);
    }

    public String deleteAnimal (Long id){
        Optional<Animal> animalFromDb = animalRepository.findById(id);
        if (animalFromDb.isEmpty()){
            throw new RuntimeException("This doctor could not found!!!");
        }
        else {
            animalRepository.delete(animalFromDb.get());
            return "Animal deleted.";
        }
    }
}
