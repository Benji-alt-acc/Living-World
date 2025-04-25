package organisms.multicellular;

public class Omnivore extends Multicellular {
    private int size;
    private int age;
    private boolean isAlive;
    private String ID;

    public Omnivore(int size, int age) {
        this.size = size;
        this.age = age;
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