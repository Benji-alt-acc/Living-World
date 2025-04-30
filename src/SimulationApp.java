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
        frame.setSize(1920, 1080);
        frame.add(panel);
        frame.setVisible(true);

        panel.spawnCreature("Fungus", 50, 50, panel);
        panel.spawnCreature("Spore", 100, 100, panel);
        panel.spawnCreature("Plant", 150, 150, panel);
        panel.spawnCreature("Seed", 200, 200, panel);
        panel.spawnCreature("Bacteria", 400, 400, panel);
        panel.spawnCreature("Virus", 450, 450, panel);
        panel.spawnCreature("Corpse", 250, 250, panel);
        panel.spawnCreature("Gorilla", 300, 300, panel);
        panel.spawnCreature("Tiger", 700, 650, panel);
        panel.spawnCreature("Crocodile", 500, 500, panel);
        //panel.drawImage(sprite, 0, 0, panel);

        // Start the simulation
        panel.startSimulation();
        panel.printCreatures();
    }

}

class SimulationPanel extends JPanel {
    private Image bacteriaSprite = createSprite("bacteriaSprite.png"); // Load the sprite image for each organism type
    private Image virusSprite = createSprite("virusSprite.png");
    private Image corpseSprite = createSprite("corpseSprite.png");
    private Image plantSprite = createSprite("plantSprite.png");
    private Image seedSprite = createSprite("seedSprite.png");
    private Image fungusSprite = createSprite("fungusSprite.png");
    private Image sporeSprite = createSprite("sporeSprite.png");
    private Image tigerSprite = createSprite("tigerSprite.png");
    private Image gorillaSprite = createSprite("gorillaSprite.png");
    private Image crocodileSprite = createSprite("crocodileSprite.png");
    private Image gasSprite;
    private final ArrayList<Organism> creatures = new ArrayList<>();
    private final Random random = new Random();

    public void printCreatures() {
        System.err.println(creatures);
    }

    public void addCreature(Organism creature) {
        creatures.add(creature);
        System.out.println("Added creature: " + creature.getClass().getSimpleName() + " at (" + creature.getX() + ", " + creature.getY() + ")");
    }

    public Image createSprite(String filename) {
        try {
            // Load the image using the classpath
            Image sprite = ImageIO.read(getClass().getResource("/img/" + filename));
            if (sprite == null) {
                throw new IOException("Image file not found at: /img/" + filename);
            }
            return sprite;
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Fallback to null if the image cannot be loaded
        }
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

            case "Bacteria":
            newCreature = new Bacteria();
            break;

            case "Virus":
            newCreature = new Virus();
            break;

            case "Corpse":
            newCreature = new Corpse();
            break;

            case "Tiger":
            newCreature = new Tiger(100, 90, 0, 0, "Tiger", "Tiger", x, y, "Tiger");
            break;

            case "Crocodile":
            newCreature = new Crocodile(70, 80, 0, 0, "Crocodile", "Crocodile", x, y, "Crocodile");
            break;

            case "Gorilla":
            newCreature = new Gorilla(100, 90, 0, 0, "Gorilla", "Gorilla", x, y, "Gorilla");
            break;

            default:
            System.out.println("Unknown type: " + type);
            break;

        }
        newCreature.setX(x);
        newCreature.setY(y);
        panel.addCreature(newCreature);
    }

    public SimulationPanel() {
    
}

    public void startSimulation() {
        Timer timer = new Timer(17, e -> {
            // Update creature positions
            for (Organism creature : creatures) {
                if (creature.canMove()) {
                int newX = creature.getX() + (random.nextBoolean() ? 1 : -1); // Move 1 unit in X direction
                int newY = creature.getY() + (random.nextBoolean() ? 1 : -1); // Move 1 unit in Y direction

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
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Draw creatures
        for (Organism creature : creatures) {
            draw(g, creature.getX(), creature.getY(), creature);
        }
    }

    private void draw(Graphics g, int x, int y, Organism creature) {
        if (creature instanceof Fungus) {
            // Use the sprite image for Fungus
            if (fungusSprite != null) {
            g.drawImage(fungusSprite, x, y, creature.getSize(), creature.getSize(), this);
            } else {
            // Fallback to cyan rectangle if the image is not loaded
            g.setColor(Color.CYAN);
            g.fillRect(x, y, creature.getSize(), creature.getSize());
            }
        } else if (creature instanceof Spore) {
            // Use the sprite image for Spore
            if (sporeSprite != null) {
            g.drawImage(sporeSprite, x, y, creature.getSize(), creature.getSize(), this);
            } else {
            // Fallback to yellow oval if the image is not loaded
            g.setColor(Color.YELLOW);
            g.fillOval(x, y, creature.getSize(), creature.getSize());
            }
        } else if (creature instanceof Plant) {
            // Use the sprite image for Plant
            if (plantSprite != null) {
            g.drawImage(plantSprite, x, y, creature.getSize(), creature.getSize(), this);
            } else {
            // Fallback to green rounded rectangle if the image is not loaded
            g.setColor(Color.GREEN);
            g.fillRoundRect(x, y, creature.getSize(), creature.getSize(), 10, 10);
            }
        } else if (creature instanceof Seed) {
            // Use the sprite image for Seed
            if (seedSprite != null) {
            g.drawImage(seedSprite, x, y, creature.getSize(), creature.getSize(), this);
            } else {
            // Fallback to orange oval if the image is not loaded
            g.setColor(Color.ORANGE);
            g.fillOval(x, y, creature.getSize(), creature.getSize());
            }
        } else if (creature instanceof Bacteria) {
            // Use the sprite image for Bacteria
            if (bacteriaSprite != null) {
            g.drawImage(bacteriaSprite, x, y, creature.getSize(), creature.getSize(), this);
            } else {
            // Fallback to gray oval if the image is not loaded
            g.setColor(Color.GRAY);
            g.fillOval(x, y, creature.getSize(), creature.getSize());
            }
        } else if (creature instanceof Virus) {
            // Use the sprite image for Virus
            if (virusSprite != null) {
            g.drawImage(virusSprite, x, y, creature.getSize(), creature.getSize(), this);
            } else {
            // Fallback to black rectangle if the image is not loaded
            g.setColor(Color.BLACK);
            g.fillRect(x, y, creature.getSize(), creature.getSize());
            }
        } else if (creature instanceof Corpse) {
            // Use the sprite image for Corpse
            if (corpseSprite != null) {
            g.drawImage(corpseSprite, x, y, creature.getSize() * 2, creature.getSize(), this);
            } else {
            // Fallback to dark gray oval if the image is not loaded
            g.setColor(Color.DARK_GRAY);
            g.fillOval(x, y, creature.getSize(), creature.getSize());
            }
        } else if (creature instanceof Tiger) {
            // Use the sprite image for Tiger
            if (tigerSprite != null) {
            g.drawImage(tigerSprite, x, y, creature.getSize(), (int)(creature.getSize() * 0.75), this);
            } else {
            // Fallback to orange rectangle if the image is not loaded
            g.setColor(Color.ORANGE);
            g.fillRect(x, y, creature.getSize(), creature.getSize());
            }
        } else if (creature instanceof Gorilla) {
            // Use the sprite image for Gorilla
            if (gorillaSprite != null) {
            g.drawImage(gorillaSprite, x, y, creature.getSize(), creature.getSize(), this);
            } else {
            // Fallback to dark gray rectangle if the image is not loaded
            g.setColor(Color.DARK_GRAY);
            g.fillRect(x, y, creature.getSize(), creature.getSize());
            }
        } else if (creature instanceof Crocodile) {
            // Use the sprite image for Crocodile
            if (crocodileSprite != null) {
            g.drawImage(crocodileSprite, x, y, creature.getSize(), creature.getSize(), this);
            } else {
            // Fallback to green rectangle if the image is not loaded
            g.setColor(Color.GREEN);
            g.fillRect(x, y, creature.getSize(), creature.getSize());
            }
        }
    }
}
