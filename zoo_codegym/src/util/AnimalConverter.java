package util;

import entity.Animal;
import entity.Bird;
import entity.Carnivore;
import entity.Herbivore;

public class AnimalConverter {

    public static String toDataString(Animal animal) {
        if (animal instanceof Carnivore c) {
            return String.join(",",
                    "CARNIVORE",
                    String.valueOf(c.getId()),
                    c.getName(),
                    String.valueOf(c.getBirthYear()),
                    c.getCage(),
                    c.getFavoritePrey()
            );
        } else if (animal instanceof Herbivore h) {
            return String.join(",",
                    "HERBIVORE",
                    String.valueOf(h.getId()),
                    h.getName(),
                    String.valueOf(h.getBirthYear()),
                    h.getCage(),
                    h.getFavoritePlant()
            );
        } else if (animal instanceof Bird b) {
            return String.join(",",
                    "BIRD",
                    String.valueOf(b.getId()),
                    b.getName(),
                    String.valueOf(b.getBirthYear()),
                    b.getCage(),
                    String.valueOf(b.getWingSpan()),
                    String.valueOf(b.isCanSpeak())
            );
        } else {
            throw new IllegalArgumentException("Unknown animal type: " + animal.getClass());
        }
    }

    public static Animal fromDataString(String line) {
        String[] parts = line.split(",");
        String type = parts[0];

        switch (type) {
            case "CARNIVORE":
                return new Carnivore(
                        parts[1],
                        parts[2],
                        Integer.parseInt(parts[3]),
                        parts[4],
                        parts[5]
                );
            case "HERBIVORE":
                return new Herbivore(
                        parts[1],
                        parts[2],
                        Integer.parseInt(parts[3]),
                        parts[4],
                        parts[5]
                );
            case "BIRD":
                return new Bird(
                        parts[1],
                        parts[2],
                        Integer.parseInt(parts[3]),
                        parts[4],
                        Double.parseDouble(parts[5]),
                        Boolean.parseBoolean(parts[6])
                );
            default:
                throw new IllegalArgumentException("Invalid animal type: " + type);
        }
    }
}
