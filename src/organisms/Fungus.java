package organisms;

public class Fungus extends Organism {
    private int size;
    private int age;
    private boolean isAlive;
    private String ID;
    private String name;

    public Fungus(int size, int age) {
        this.size = size;
        this.age = age;
        this.isAlive = true;
        this.ID = generateID("F");
    }

    public void grow() {
        if (isAlive) {
            size += 1; // Increase size by 1 unit
        }
    }

    public void propagate() {
        if (isAlive) {
            // Logic for propagation (spreading spores)
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