package organisms.animal;

import organisms.Organism;

public abstract class Animal extends Organism {
    private int strength;
    private boolean hasVirus = false;
    private boolean hasBacteria = false;
    public Animal(int health, int size, int age, int hunger, String ID, String type, int x, int y, int dx, int dy, String speciesname, int strength) {
        super(health, size, age, hunger, ID, type, x, y, dx, dy, speciesname);
        this.strength = strength;
    }

    public void makeNoise() {
        System.out.println("Animal noise");
    }

    public void eat(Organism entree) {
        System.out.println(this.getSpeciesName() + " IS EATING " + entree.getSpeciesName());
        this.setHealth(this.getHealth()+(entree.getSize()/5));
    }

    public void sleep() {
        System.out.println("Sleeping");
    }

    public int getStrength() {
        return this.strength;
    }

    public void setStrength(int newStrength) {
        this.strength = newStrength;
    }
}