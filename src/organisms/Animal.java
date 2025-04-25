package organisms;

public abstract class Animal extends Organism {
    private int hunger;
    
    public void eat(int foodAmount) {
        // eat food (fungus, plant, or other animal)
    }

    public void move() {
        // Move the animal
    }

    public void expelWaste() {
        // Expel waste
    }

}