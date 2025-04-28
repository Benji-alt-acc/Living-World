package organisms.multicellular.fungi;

import organisms.Organism;

public class Fungus extends Organism {
    private int size;
    private int age;
    private boolean isAlive;
    private String ID;

    public Fungus(int size, int age) {
        this.size = size;
        this.age = age;
        this.isAlive = true;
        this.ID = generateID("F");
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