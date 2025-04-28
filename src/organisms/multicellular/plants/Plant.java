package organisms.multicellular.plants;
import organisms.Organism;

public class Plant extends Organism {
    private int size;
    private int age;
    private String name;
    private String ID;
    
    public Plant(int size, int age) {
        this.size = size;
        this.age = age;
        this.ID = generateID("P");
    }

    public void grow() {
        // Grow the plant
    }

    public void photosynthesize() {
        breathe();
        // Photosynthesize (breathe and produce energy)
    }

    public void propagate() {
        // Spread seeds
    }

}