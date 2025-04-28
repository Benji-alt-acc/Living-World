package organisms;

public class Corpse extends Organism {
    private String ID;
    private int foodValue;
    private boolean isAlive = false; // Corpse is not alive

    public Corpse(String ID, int foodValue) {
        this.ID = generateID("CR");
        this.foodValue = foodValue;
    }

    public void consumed() {
        // Logic for getting eaten by fungus or bacteria
    }


}
