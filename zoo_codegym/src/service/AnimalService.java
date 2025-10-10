package service;

import entity.Animal;
import entity.Bird;
import entity.Carnivore;
import entity.Herbivore;
import repository.AnimalRepository;
import repository.IAnimalRepository;
import util.AnimalConverter;

import java.util.ArrayList;
import java.util.List;

public class AnimalService implements IAnimalService<Animal> {

    private static final IAnimalRepository<String> animalRepository = new AnimalRepository();

    @Override
    public List<Animal> findAll() {
        List<String> lines = animalRepository.loadFromFile();
        List<Animal> animals = new ArrayList<>();
        for (String line : lines) {
            try {
                Animal animal = AnimalConverter.fromDataString(line);
                animals.add(animal);
            } catch (NumberFormatException e) {
                System.out.println(" Lỗi sai định dạng năm!");
            }catch (Exception e){
                System.out.println(" Lôi đọc file!");
            }
        }
        return animals;
    }

    @Override
    public boolean add(Animal animal) {
        if (animal != null) {
            String line = AnimalConverter.toDataString(animal);
            List<String> animals = new ArrayList<>();
            animals.add(line);
            animalRepository.appendToFile(animals, true);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteByCode(String codeAnimal) {
        List<Animal> animals = findAll();
        if (!codeAnimal.isBlank()) {
            Animal toDelete = findByCode(codeAnimal);
            if (toDelete == null) {
                return false;
            }
            animals.remove(toDelete);
            List<String> updatedLines = new ArrayList<>();
            for (Animal animal : animals) {
                updatedLines.add(AnimalConverter.toDataString(animal));
            }
            animalRepository.writeToFile(updatedLines);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public void update(Animal animal) {
        List<Animal> animals = findAll();

        for (Animal animal1 : animals) {
            if (animal1.getId().equalsIgnoreCase(animal.getId())) {
                animal1.setName(animal.getName());
                animal1.setBirthYear(animal.getBirthYear());
                animal1.setCage(animal.getCage());

                if (animal instanceof Carnivore && animal1 instanceof Carnivore) {
                    ((Carnivore) animal1).setFavoritePrey(((Carnivore) animal).getFavoritePrey());
                } else if (animal instanceof Herbivore && animal1 instanceof Herbivore) {
                    ((Herbivore) animal1).setFavoritePlant(((Herbivore) animal).getFavoritePlant());
                } else if (animal instanceof Bird && animal1 instanceof Bird) {
                    ((Bird) animal1).setWingSpan(((Bird) animal).getWingSpan());
                    ((Bird) animal1).setCanSpeak(((Bird) animal).isCanSpeak());
                }
                break;
            }
        }

        List<String> updatedLines = new ArrayList<>();
        for (Animal a : animals) {
            updatedLines.add(AnimalConverter.toDataString(a));
        }
        animalRepository.writeToFile(updatedLines);
    }

    @Override
    public List<Animal> findByName(String name) {
        List<Animal> animals = new ArrayList<>();
        if (name != null && !name.isBlank()) {
            for (Animal animal : findAll()) {
                if (animal.getName().toLowerCase().contains(name.toLowerCase())) {
                    animals.add(animal);
                }
            }
        }
        return animals;
    }

    @Override
    public Animal findByCode(String code) {
        if (code != null && !code.isBlank()) {
            for (Animal animal : findAll()) {
                if (animal.getId().equalsIgnoreCase(code)) {
                    return animal;
                }
            }
        }
        return null;
    }
}
