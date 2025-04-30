package organisms.multicellular;

public class Herbivore extends Multicellular {
    private int size;
    private int age;
    private boolean isAlive;
    private String ID;

    public Herbivore() {
        super(0, 50, 0, 0, "default1", "default2", 0, 0, "default3");
        this.size = 50;
        this.age = 0;
        this.isAlive = true;
        this.ID = generateID("H");
    }

    public void flee() {
        // Logic for fleeing from predators
    }

}