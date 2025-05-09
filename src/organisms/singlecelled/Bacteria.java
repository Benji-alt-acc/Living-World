package organisms.singlecelled;

public class Bacteria extends SingleCelled {
    private int size = 1;
    private int age;
    private boolean isAlive;
    private String ID;
    private String hostID;

    public Bacteria() {
        super(1, 25, 0, 0, "Bacteria", "BacteriaType", 0, 0, 0, 0, "BacteriaSpecies");
        this.size = 25;
        this.age = 0;
        this.isAlive = true;
        this.ID = generateID("B");
    }

    public void infiltrate(String hostID) {
        // Logic for infiltrating host
    }

    public void help() {
        // Logic for helping the host
    }
    
    public void harm() {
        // Logic for harming the host
    }
}