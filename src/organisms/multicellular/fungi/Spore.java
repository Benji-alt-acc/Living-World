package organisms.multicellular.fungi;
import organisms.Organism;

public class Spore extends Organism {
    private String ID;

    public Spore() {
        super(0, 5, 0, 0, "SP", "defaultName", 1, 1, "defaultType"); // Replace with appropriate values
        this.ID = generateID("SP");
    }

    public void germinate() {
        // Logic for "germinating" spore (remove spore, spawn fungus)
    }
}
