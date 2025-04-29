package world;
import java.util.ArrayList;
import java.util.Random;

public class Gas {
    public String gasName;
    public boolean isOxygen;
    public boolean isCarbonDioxide;
    public int lethalConcentration;
    public String ID;
    ArrayList<String>[] gasIDs = new ArrayList[999];

    public Gas(int lethalConcentration, String gasname, String gasName){
        this.lethalConcentration = lethalConcentration;
        this.gasName = gasName;
    }

    public void consume() {
        // Consume gas and delete from world
    }

    public void move() {
        // Move gas
    }

    public Gas(String type) {
        this.ID = generateID("G");

        if (type.equals("Oxygen")) {
            this.isOxygen = true;
            this.isCarbonDioxide = false;
        } else if (type.equals("CarbonDioxide")) {
            this.isOxygen = false;
            this.isCarbonDioxide = true;
        }
    }

    public String generateID(String type) {
        Random random = new Random();
        int idNum;
        do {
            idNum = 10000 + random.nextInt(90000); // Generate a random 5-digit number
        } while (gasIDs[idNum % gasIDs.length] != null); // Ensure no collision
        return type + idNum;
    }

}
