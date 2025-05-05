package organisms.multicellular.plants;
import organisms.Organism;

public class Plant extends Organism {
    private int size;
    private int age;
    private String ID;
    
    public Plant() {
        super(10, 50, 0, 0, "Plant", "PlantType", 0, 0, 0, 0, "PlantSpecies"); // Adjust arguments as needed
        this.size = size;
        this.age = age;
        this.ID = generateID(ID);
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