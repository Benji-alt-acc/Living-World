package organisms.multicellular.plants;
import organisms.Organism;

public class Plant extends Organism {
    private int size;
    private int age;
    private String name;
    private String ID;
    
    public Plant() {
        super(10, 10, 0, 0, "DefaultName", "DefaultType", 0, 0, "DefaultCategory"); // Adjust arguments as needed
        this.size = size;
        this.age = age;
        this.ID = generateID("P");
    }

    public void grow() {
        // Grow the plant
    }

    @Override
    public boolean canMove() {
        return false;
    }

    public void photosynthesize() {
        breathe();
        // Photosynthesize (breathe and produce energy)
    }

    public void propagate() {
        // Spread seeds
    }

}