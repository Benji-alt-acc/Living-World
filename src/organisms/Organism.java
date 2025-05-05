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
    private String type;
    private int x;
    private int y;
    private int dx;
    private int dy;
    private String speciesname;
    private boolean isPaused;
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
        this.isPaused = false;
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

    public void pauseInteractions() {                        // pauses interactions for 5 seconds (resumeInteractions runs every 5 seconds (in incrementTime function) to reset isPaused to false)
        isPaused = true;
    }

    public void resumeInteractions() {
        isPaused = false;
    }

    public boolean isPaused() {
        return isPaused;
    }

    public void breathe() {
        // Breathe in O2/CO2 and breathe out the opposite
    }

    public boolean canMove() {
        return true;
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

    public int getHunger() {
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

    public void increaseAge(int val) {
        age += val;
    }

    public void increaseHunger(int val) {
        hunger += val;
    }

    public void increaseSize(int val) {
        size += val;
    }

    public void decreaseHunger(int val) {
        hunger -= val;
    }

    public void decreaseSize(int val) {
        size -= val;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public String setID(String ID) {
        return ID;
    }

    public void setType(String type) {
        this.type = type;
    }
}