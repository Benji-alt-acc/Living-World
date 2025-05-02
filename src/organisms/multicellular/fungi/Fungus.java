package organisms.multicellular.fungi;

import organisms.Organism;

public class Fungus extends Organism {
    private int size = 50;
    private int age;
    private boolean isAlive;
    private String ID;

    public Fungus() {
        super(10, 50, 0, 0, "Fungus", "FungusType", 0, 0, 0, 0, "FungusSpecies"); // Adjust the arguments as per the Organism constructor
        this.size = 50;
        this.age = 0;
        this.isAlive = true;
        this.ID = generateID("F");
    }

    @Override
    public boolean canMove() {
        return false;
    }

    public void grow(int amount) {
        if (isAlive) {
            size += amount;
        }
    }

    public void propagate() {
        if (isAlive) {
            // Logic for spreading spores
        }
    }

    public void fruit() {
        if (isAlive) {
            // Logic for fruiting (mushrooms formation)
        }
    }

    public void digest() {
        if (isAlive) {
            // Logic for digestion of dead organism (corpse)
            // Include release of gasses, increase enery for fungus, release spores, etc.
        }
    }

}