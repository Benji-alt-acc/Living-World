package organisms.singlecelled;
import organisms.Organism;

public abstract class SingleCelled extends Organism {

    public SingleCelled(int health, int size, int age, int hunger, String ID, String type, int x, int y, int dx, int dy, String speciesname) {
        super(health, size, age, hunger, ID, type, x, y, dx, dy, speciesname);
    }

    public void replicate() {
        }

}