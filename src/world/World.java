package world;
import organisms.Organism;
import java.util.ArrayList;
import java.util.Random;

public class World {

    private ArrayList<Organism> currentLiving = new ArrayList<>();
    private Random random = new Random();
    public World(int num) {
        for (int i = 0; i < num; i++) {
            switch (random.nextInt(3)) {
                case 0: currentLiving.add(new Bacteria());   
                break;
                case 1: currentLiving.add(new ());     
                break;
                default: currentLiving.add(new ()); 
                break;
            }
        }
    }
    public ArrayList<Organism> getLiving() {
        return currentLiving;
    }

    public void spawnOrganism(String type) {
        // Spawn an organism of the specified type
    }

    public void spawnGenericFood(int amount) {
        // Spawn generic food in the world
    }

    public void spawnGas(String type) {
        // Spawn gas in the world
    }

}
