package organisms.multicellular;

public class Carnivore extends Multicellular {
    private int size;
    private int age;
    private boolean isAlive;
    private String ID;

    public Carnivore() {
        super(0, 50, 0, 0, "default1", "default2", 0, 0, "default3"); // Replace with appropriate arguments
        this.size = 50;
        this.age = 0;
        this.isAlive = true;
        this.ID = generateID("C");
    }

    public void attack(String preyID) {
        // Logic for attacking prey, consuming, gaining energy, etc.
    }

}