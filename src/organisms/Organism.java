package organisms;

import java.util.ArrayList;
import java.util.Random;

public abstract class Organism {
    // Reference the organismIDs from Simulation class
    public static ArrayList<String> organismIDs = new ArrayList<>();
    private int health;
    private int size;
    private int age;
    private int hunger;
    private String ID;
    private boolean isAlive;
    private String type;
    private int x;
    private int y;
    private int dx;
    private int dy;
    private String speciesname;
    // private int strength;

    public Organism(int health, int size, int age, int hunger, String ID, String type, int x, int y, int dx, int dy, String speciesname) {
        this.health = health;
        this.size = size;
        this.age = age;
        this.hunger = hunger;
        this.ID = generateID(ID);
        this.type = type;
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.speciesname = speciesname;
        // this.strength = strength;
    }

    public String generateID(String type) {
        // This function takes in a string "type", generates 5 random numbers after it, and returns the new ID string
        Random random = new Random();
        String newID;
        do {
            int idNum = 10000 + random.nextInt(90000); // Generate a random 5-digit number
            newID = type + idNum;
        } while (organismIDs.contains(newID)); // Ensure no duplicate
        organismIDs.add(newID); // Add the new ID to the list
        return newID;
    }

    public void die(String orgID) {
        if (organismIDs.contains(orgID)) {
            organismIDs.remove(orgID); // Remove organism from the list of IDs
            this.isAlive = false;      // Set organism to dead (becomes corpse)
            // INSERT LOGIC TO TURN ORGANISM INTO CORPSE (remove organism, spawn corpse)
        }
    }

    public void breathe() {
        // Breathe in O2/CO2 and breathe out the opposite
    }

    public boolean canMove() {
        return true;
    }

    public void eaten() {
        // Organism gets eaten, remove from world, return food value?
    }

    public int getHealth() {
        return health;
    }

    public int getSize() {
        return size;
    }

    public int getAge() {
        return age;
    }

    public int gethunger() {
        return hunger;
    }

    public String getID() {
        return this.ID;
    }

    public String getType() {
        return type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public String getSpeciesName() {
        return speciesname;
    }

    public void setX(int i) {
        this.x = i;
    }

    public void setY(int i) {
        this.y = i;
    }

    public void setDx(int i) {
        this.dx = i;
    }

    public void setDy(int i) {
        this.dy = i;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void sethunger(int hunger) {
        this.hunger = hunger;
    }

    public String setID(String ID) {
        return ID;
    }

    public void setType(String type) {
        this.type = type;
    }
}