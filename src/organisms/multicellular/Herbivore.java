package organisms.multicellular;

public class Herbivore extends Multicellular {
    private int size;
    private int age;
    private boolean isAlive;
    private String ID;

    public Herbivore(int size, int age) {
        this.size = size;
        this.age = age;
        this.isAlive = true;
        this.ID = generateID("H");
    }

    public void flee() {
        // Logic for fleeing from predators
    }

}