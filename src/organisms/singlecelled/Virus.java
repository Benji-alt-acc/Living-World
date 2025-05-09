package organisms.singlecelled;

public class Virus extends SingleCelled {
    private int size = 25;
    private int age;
    private boolean isAlive;
    public String ID;
    private String hostID;

    public Virus() {
        super(100, 25, 0, 0, "Virus", "VirusType", 0, 0, 0, 0, "VirusSpecies");
        this.isAlive = true; 
        this.ID = generateID(ID);
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