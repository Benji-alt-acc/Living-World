package organisms.singlecelled;

public class Bacteria extends SingleCelled {
    private int size = 1;
    private int age;
    private boolean isAlive;
    private String ID;

    public Bacteria() {
        super(1, 5, 0, 0, "default1", "default2", 0, 0, "default3");
        this.size = 1;
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