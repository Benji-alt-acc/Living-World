package organisms.animal;

import organisms.Organism;

public abstract class Animal extends Organism {
    public Animal(int health, int size, int age, int hunger, String ID, String type, int x, int y, String speciesname) {
        super(health, size, age, hunger, ID, type, x, y, "Gorilla");
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
}