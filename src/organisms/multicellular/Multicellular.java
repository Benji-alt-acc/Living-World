package organisms.multicellular;

import organisms.Organism;

public abstract class Multicellular extends Organism{
    private int size;
    private int age;
    private boolean isAlive;

    public Multicellular(int health, int size, int age, int hunger, String ID, String type, int x, int y, String speciesname) {
        super(health, size, age, hunger, ID, type, x, y, speciesname);
        this.size = size;
        this.age = age;
        this.isAlive = true;
    }

    public void breed() {
        // Reproduce
    }

    public void sleep() {
        // Sleep
    }

    public void grow() {
        // Grow
    }

}

