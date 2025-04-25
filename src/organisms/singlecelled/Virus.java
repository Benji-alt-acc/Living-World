package organisms.singlecelled;

public class Virus extends SingleCelled {
    private int size = 1;
    private int age;
    private boolean isAlive;
    public String ID;

    public Virus() {
        this.isAlive = true; // though viruses are not considered alive in the traditional sense, 
                             // we can set this to true for the sake of this simulation
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