package entity;

public class Carnivore extends Animal {
    private String favoritePrey;

    public Carnivore(String id, String name, int birthYear, String cage, String favoritePrey) {
        super(id, name, birthYear, cage);
        this.favoritePrey = favoritePrey;
    }


    public Carnivore() {
    }

    public String getFavoritePrey() {
        return favoritePrey;
    }

    public void setFavoritePrey(String favoritePrey) {
        this.favoritePrey = favoritePrey;
    }

    @Override
    public String toString() {
        return super.toString() + " | Carnivore{favoritePrey='" + favoritePrey + "'}";
    }


}
