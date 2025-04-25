package organisms;

public class Plant extends Organism {
    private int size;
    private int age;
    private String name;
    private String ID;
    
    public Plant(int size, int age) {
        this.size = size;
        this.age = age;
        this.ID = generateID("P");
    }

    public void grow() {
        // Grow the plant
    }

    public void breathe() {
        // Breathe in CO2 and release O2
    }

    public void photosynthesize() {
        breathe();
        // Photosynthesize (breathe and produce energy)
    }

    public void propagate() {
        // Reproduce
    }

}