package organisms.multicellular;

public class Carnivore extends Multicellular {
    private int size;
    private int age;
    private boolean isAlive;
    private String ID;

    public Carnivore(int size, int age) {
        this.size = size;
        this.age = age;
        this.isAlive = true;
        this.ID = generateID("C");
    }

    public void attack(String preyID) {
        // Logic for attacking prey, consuming, gaining energy, etc.
    }

}