import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
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

public class SimulationApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("A Living World");
        SimulationPanel panel = new SimulationPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(panel);
        frame.setVisible(true);

        // Start the simulation
        panel.startSimulation();
    }
}

class SimulationPanel extends JPanel {
    private final ArrayList<Creature> creatures = new ArrayList<>();
    private final Random random = new Random();

    public SimulationPanel() {
        // Initialize creatures
        for (int i = 0; i < 10; i++) {
            creatures.add(new Creature(random.nextInt(800), random.nextInt(600)));
        }
        Plant plant1 = new Plant(1, 1);
        Seed seed1 = new Seed();
        Fungus fungus1 = new Fungus(1,1);
        Spore spore1 = new Spore();
        Carnivore carnivore1 = new Carnivore(1, 1);
        Herbivore herbivore1 = new Herbivore(1, 1);
        Omnivore omnivore1 = new Omnivore(1,1);
        Bacteria bacteria1 = new Bacteria(1, 1);
        Virus virus1 = new Virus();
        Corpse corpse1 = new Corpse(1);


    }

    public void startSimulation() {
        Timer timer = new Timer(50, e -> {
            // Update creature positions
            for (Creature creature : creatures) {
                creature.move();
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
        for (Creature creature : creatures) {
            creature.draw(g);
        }
    }
}

class Creature {
    private int x, y;
    private final int size = 5;
    private final Random random = new Random();

    public Creature(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move() {
        // Random movement
        x += random.nextInt(11) - 5; // Move between -5 and +5
        y += random.nextInt(11) - 5;

        // Keep within bounds
        x = Math.max(0, Math.min(780, x));
        y = Math.max(0, Math.min(580, y));
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(x, y, size, size);
    }
}
