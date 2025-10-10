package entity;

public class Herbivore extends Animal {
    private String favoritePlant;


    public Herbivore() {
    }

    public Herbivore(String favoritePlant) {
        this.favoritePlant = favoritePlant;
    }

    public Herbivore(String id, String name, int birthYear, String cage, String favoritePlant) {
        super(id, name, birthYear, cage);
        this.favoritePlant = favoritePlant;
    }

    public String getFavoritePlant() {
        return favoritePlant;
    }

    public void setFavoritePlant(String favoritePlant) {
        this.favoritePlant = favoritePlant;
    }

    @Override
    public String toString() {
        return super.toString() + " | Herbivore{favoritePlant='" + favoritePlant + "'}";
    }
}
