package organisms.multicellular.fungi;
import organisms.Organism;

public class Spore extends Organism {
    private String ID;

    public Spore() {
        this.ID = generateID("SP");
    }

    public void germinate() {
        // Logic for "germinating" spore (remove spore, spawn fungus)
    }
}
