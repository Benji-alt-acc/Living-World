package organisms.singlecelled;

public class Bacteria extends SingleCelled {
    private int size = 1;
    private int age;
    private boolean isAlive;
    private String ID;

    public Bacteria(int size, int age) {
        this.size = size;
        this.age = age;
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