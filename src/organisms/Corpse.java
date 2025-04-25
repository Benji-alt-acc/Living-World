package organisms;

public class Corpse extends Organism {
    private String ID;
    private int foodValue;
    private boolean isAlive = false; // Corpse is not alive

    public Corpse(String ID, int foodValue) {
        this.ID = generateID("CR");
        this.foodValue = foodValue;
    }

    public void decompose() {
        // Logic for decomposition, eaten by fungus
    }


}
