package organisms.multicellular.plants;
import organisms.Organism;

public class Seed extends Organism {
    private String ID;
    
    public Seed() {
        super(0, 25, 0, 0, "Seed", "SeedType", 1, 1, 0, 0, "SeedSpecies"); // Pass appropriate arguments to the Organism constructor
        this.ID = generateID("S");
    }

    public void germinate() {
        // Logic for germinating seed (despawn seed, spawn new plant in its place)
    }

    public void move(String direction) {
        switch (direction) {
            case "L":
                // move left
                break;
            case "R":
                // move right
                break;
            case "U":
                // move up
                break;
            case "D":
                // move down
                break;
            default:
                // handle invalid direction
                break;
        }
    }
}
