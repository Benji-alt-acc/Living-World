import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import organisms.Organism;
import organisms.multicellular.Carnivore;
import organisms.multicellular.Herbivore;
import organisms.multicellular.Omnivore;
import organisms.multicellular.fungi.Fungus;
import organisms.multicellular.fungi.Spore;
import organisms.multicellular.plants.Plant;
import organisms.multicellular.plants.Seed;
import organisms.singlecelled.Bacteria;
import organisms.singlecelled.Virus;
import organisms.Corpse;
import world.Gas;
import organisms.animal.Tiger;
import organisms.animal.Gorilla;
import organisms.animal.Crocodile;

public class SimulationApp {
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("A Living World");
        SimulationPanel panel = new SimulationPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(panel);
        frame.setVisible(true);

        panel.spawnCreature("Fungus", 50, 50, panel);
        panel.spawnCreature("Spore", 100, 100, panel);
        panel.spawnCreature("Plant", 150, 150, panel);
        panel.spawnCreature("Seed", 200, 200, panel);
        panel.spawnCreature("Carnivore", 250, 250, panel);
        panel.spawnCreature("Herbivore", 300, 300, panel);
        panel.spawnCreature("Omnivore", 350, 350, panel);
        panel.spawnCreature("Bacteria", 400, 400, panel);
        panel.spawnCreature("Virus", 450, 450, panel);
        panel.spawnCreature("Corpse", 250, 250, panel);
        //panel.drawImage(sprite, 0, 0, panel);

        // Start the simulation
        panel.startSimulation();
        panel.printCreatures();
    }

}

class SimulationPanel extends JPanel {
    private Image sprite;

    {
        try {
            sprite = ImageIO.read(new File("src/img/yourSpriteImage.png"));
        } catch (IOException e) {
            e.printStackTrace();
            sprite = null; // Fallback to null if the image cannot be loaded
        }
    }
    private final ArrayList<Organism> creatures = new ArrayList<>();
    private final Random random = new Random();

    public void printCreatures() {
        System.err.println(creatures);
    }

    public void addCreature(Organism creature) {
        creatures.add(creature);
        System.out.println("Added creature: " + creature.getClass().getSimpleName() + " at (" + creature.getX() + ", " + creature.getY() + ")");
    }

    public void spawnCreature(String type, int x, int y, SimulationPanel panel) {
        Organism newCreature = null;
        switch (type) {
            case "Fungus":
            newCreature = new Fungus();
            break;

            case "Spore":
            newCreature = new Spore();
            break;

            case "Plant":
            newCreature = new Plant();
            break;

            case "Seed":
            newCreature = new Seed();
            break;

            case "Carnivore":
            newCreature = new Carnivore();
            break;

            case "Herbivore":
            newCreature = new Herbivore();
            break;

            case "Omnivore":
            newCreature = new Omnivore();
            break;

            case "Bacteria":
            newCreature = new Bacteria();
            break;

            case "Virus":
            newCreature = new Virus();
            break;

            case "Corpse":
            newCreature = new Corpse();
            break;

            default:
            System.out.println("Unknown type: " + type);
            break;

            // case "Gorilla":
            // newCreature = new Gorilla();
            // break;

            
        }
        newCreature.setX(x);
        newCreature.setY(y);
        panel.addCreature(newCreature);
    }

    public SimulationPanel() {
    
}

    public void startSimulation() {
        Timer timer = new Timer(50, e -> {
            // Update creature positions
            for (Organism creature : creatures) {
                if (creature.canMove()) {
                int newX = creature.getX() + random.nextInt(11) - 5; // Move randomly in X direction
                int newY = creature.getY() + random.nextInt(11) - 5; // Move randomly in Y direction

                // Ensure the creature stays within bounds
                newX = Math.max(0, Math.min(getWidth() - creature.getSize(), newX));
                newY = Math.max(0, Math.min(getHeight() - creature.getSize(), newY));

                creature.setX(newX);
                creature.setY(newY);
                }
            }
            // Repaint the panel
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw background
        g.drawImage(sprite, 100, 100, 200, 200, this);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Draw creatures
        for (Organism creature : creatures) {
            draw(g, creature.getX(), creature.getY(), creature);
        }
    }

    private void draw(Graphics g, int x, int y, Organism creature) {
        if (creature instanceof Fungus) {
            g.setColor(Color.CYAN);
            g.fillRect(x, y, creature.getSize(), creature.getSize());
        } else if (creature instanceof Spore) {
            g.setColor(Color.YELLOW);
            g.fillOval(x, y, creature.getSize(), creature.getSize());
        } else if (creature instanceof Plant) {
            g.setColor(Color.GREEN);
            g.fillRoundRect(x, y, creature.getSize(), creature.getSize(), 10, 10);
        } else if (creature instanceof Seed) {
            g.setColor(Color.ORANGE);
            g.fillOval(x, y, creature.getSize(), creature.getSize());
        } else if (creature instanceof Carnivore) {
            g.setColor(Color.RED);
            g.fillRect(x, y, creature.getSize(), creature.getSize());
        } else if (creature instanceof Herbivore) {
            g.setColor(Color.MAGENTA);
            g.fillOval(x, y, creature.getSize(), creature.getSize());
        } else if (creature instanceof Omnivore) {
            g.setColor(Color.PINK);
            g.fillRoundRect(x, y, creature.getSize(), creature.getSize(), 5, 5);
        } else if (creature instanceof Bacteria) {
            g.setColor(Color.GRAY);
            g.fillOval(x, y, creature.getSize(), creature.getSize());
        } else if (creature instanceof Virus) {
            g.setColor(Color.BLACK);
            g.fillRect(x, y, creature.getSize(), creature.getSize());
        } else if (creature instanceof Corpse) {
            g.setColor(Color.darkGray);
            g.fillOval(x, y, creature.getSize(), creature.getSize());
         }
    }
}
