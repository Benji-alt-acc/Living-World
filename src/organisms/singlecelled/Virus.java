package organisms.singlecelled;

public class Virus extends SingleCelled {
    private int size = 25;
    private int age;
    private boolean isAlive;
    public String ID;

    public Virus() {
        super(100, 25, 0, 50, "defaultID", "Virus", 0, 0, "VirusSpecies");
        this.isAlive = true; 
        this.ID = generateID("V");
    }

    public void infiltrate(String hostID) {
        if (isAlive) {
            // Logic for infecting a host
        }
    }

    public void harm() {
        // Logic for harming the host
    }
}