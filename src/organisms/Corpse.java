package organisms;

public class Corpse extends Organism {
    private String ID;
    private int foodValue;
    private boolean isAlive = false; // Corpse is not alive

    public Corpse() {
        super(0, 10, 0, 0, "Corpse", "defaultSpecies", 0, 0, "defaultBehavior"); // Pass appropriate values to match the Organism constructor
        this.ID = generateID("CR");
        this.foodValue = foodValue;
    }

    @Override
    public boolean canMove() {
        return false;
    }

    public void consumed() {
        // Logic for getting eaten by fungus or bacteria
    }


}
