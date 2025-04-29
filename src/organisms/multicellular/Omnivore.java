package organisms.multicellular;

public class Omnivore extends Multicellular {
    private int size;
    private int age;
    private boolean isAlive;
    private String ID;

    public Omnivore() {
        super(100, 10, 1, 50, "Multicellular", "Multicellular", 0, 0, "SpeciesName");
        this.size = 0;
        this.age = 0;
        this.isAlive = true;
        this.ID = generateID("O");
    }

    public void flee() {
        // Logic for fleeing from predators
    }

    public void attack() {
        // Logic for attacking prey
    }

}