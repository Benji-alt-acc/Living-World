package organisms;
import java.util.ArrayList;
import java.util.Random;

public abstract class Organism {
    public ArrayList<String>[] organismIDs = new ArrayList[999];
    private int health;
    private int size;
    private int age;
    private int energy;
    private String ID;
    private boolean isAlive;

    public String generateID(String type) {
        Random random = new Random();
        int idNum;
        do {
            idNum = 10000 + random.nextInt(90000); // Generate a random 5-digit number
        } while (organismIDs[idNum % organismIDs.length] != null); // Ensure no duplicate
        return type + idNum;
    }

    public void die(String orgID) {
        for (ArrayList<String> list : organismIDs) {
            if (list != null && list.contains(orgID)) {
                list.remove(orgID);                     // Remove organism from list of organisms
                this.isAlive = false;                   // Set organism to dead (becomes corpse)
                break;
            }
            // INSERT LOGIC TO TURN ORGANISM INTO CORPSE (remove organism, spawn corpse)
        }
    }

    public void breathe() {
        // Breathe in O2/CO2 and breathe out the opposite
    }

    public void eaten() {
        // Organism gets eaten, remove from world, return food value?
    }

}