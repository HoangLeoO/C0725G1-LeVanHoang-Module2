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
    private static List<Animal> cache = new ArrayList<>();


    public AnimalService() {
        loadFromFileOnce();
    }


    private void loadFromFileOnce() {
        if (!cache.isEmpty()) return;
        List<String> lines = animalRepository.loadFromFile();
        for (String line : lines) {
            try {
                cache.add(AnimalConverter.fromDataString(line));
            } catch (Exception e) {
                System.out.println("Lỗi khi đọc dòng dữ liệu: " + line);
            }
        }
        System.out.println("Dữ liệu động vật đã được nạp vào cache.");
    }

    private void saveCacheToFile() {
        List<String> lines = new ArrayList<>();
        for (Animal a : cache) {
            lines.add(AnimalConverter.toDataString(a));
        }
        animalRepository.writeToFile(lines);
    }

    @Override
    public List<Animal> findAll() {
        return new ArrayList<>(cache);
    }

    @Override
    public boolean add(Animal animal) {
        if (animal == null) return false;
        cache.add(animal);
        saveCacheToFile();
        return true;
    }

    @Override
    public boolean deleteByCode(String codeAnimal) {
        if (codeAnimal == null || codeAnimal.isBlank()) return false;

        Animal toDelete = findByCode(codeAnimal);
        if (toDelete == null) return false;

        cache.remove(toDelete);
        saveCacheToFile();
        return true;
    }


    @Override
    public boolean update(Animal animal) {
        if (animal == null || animal.getId() == null) return false;

        for (Animal existing : cache) {
            if (existing.getId().equalsIgnoreCase(animal.getId())) {
                existing.setName(animal.getName());
                existing.setBirthYear(animal.getBirthYear());
                existing.setCage(animal.getCage());

                // Cập nhật thuộc tính riêng
                if (animal instanceof Carnivore c && existing instanceof Carnivore e) {
                    e.setFavoritePrey(c.getFavoritePrey());
                } else if (animal instanceof Herbivore c && existing instanceof Herbivore e) {
                    e.setFavoritePlant(c.getFavoritePlant());
                } else if (animal instanceof Bird c && existing instanceof Bird e) {
                    e.setWingSpan(c.getWingSpan());
                    e.setCanSpeak(c.isCanSpeak());
                }
                saveCacheToFile();
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Animal> findByName(String name) {
        if (name == null || name.isBlank()) return List.of();
        List<Animal> result = new ArrayList<>();
        for (Animal a : cache) {
            if (a.getName().toLowerCase().contains(name.toLowerCase().trim())) {
                result.add(a);
            }
        }
        return result;
    }

    @Override
    public Animal findByCode(String code) {
        if (code == null || code.isBlank()) return null;
        for (Animal a : cache) {
            if (a.getId().equalsIgnoreCase(code.trim())) {
                return a;
            }
        }
        return null;
    }
}
