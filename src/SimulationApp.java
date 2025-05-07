import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;
import organisms.Corpse;
import organisms.Organism;
import organisms.animal.Animal;
import organisms.animal.Crocodile;
import organisms.animal.Gorilla;
import organisms.animal.Tiger;
import organisms.animal.Deer;
import organisms.multicellular.fungi.Fungus;
import organisms.multicellular.fungi.Spore;
import organisms.multicellular.plants.Plant;
import organisms.multicellular.plants.Seed;
import organisms.singlecelled.Bacteria;
import organisms.singlecelled.Virus;
import world.Weather;

//MINE
public class SimulationApp {
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("A Living World");
        SimulationPanel panel = new SimulationPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.add(panel);
        frame.setVisible(true);

        //initializes overlay panel to display weather
        SimulationPanel.ImageOverlayPanel overlay = panel.new ImageOverlayPanel("snow_falling.gif", 0.5f); // 50% opacity
        overlay.setSize(frame.getSize());
        frame.setGlassPane(overlay);
        overlay.setVisible(true);

        
        panel.spawnCreature("Gorilla", SimulationApp.randX(), SimulationApp.randY(), panel);
        panel.spawnCreature("Gorilla", SimulationApp.randX(), SimulationApp.randY(), panel);
        panel.spawnCreature("Gorilla", SimulationApp.randX(), SimulationApp.randY(), panel);
        panel.spawnCreature("Gorilla", SimulationApp.randX(), SimulationApp.randY(), panel);
        panel.spawnCreature("Gorilla", SimulationApp.randX(), SimulationApp.randY(), panel);
        panel.spawnCreature("Crocodile", SimulationApp.randX(), SimulationApp.randY(), panel);
        panel.spawnCreature("Crocodile", SimulationApp.randX(), SimulationApp.randY(), panel);
        panel.spawnCreature("Crocodile", SimulationApp.randX(), SimulationApp.randY(), panel);
        panel.spawnCreature("Crocodile", SimulationApp.randX(), SimulationApp.randY(), panel);
        panel.spawnCreature("Crocodile", SimulationApp.randX(), SimulationApp.randY(), panel);
        panel.spawnCreature("Crocodile", SimulationApp.randX(), SimulationApp.randY(), panel);
        panel.spawnCreature("Crocodile", SimulationApp.randX(), SimulationApp.randY(), panel);
        panel.spawnCreature("Crocodile", SimulationApp.randX(), SimulationApp.randY(), panel);
        panel.spawnCreature("Tiger", SimulationApp.randX(), SimulationApp.randY(), panel);
        panel.spawnCreature("Tiger", SimulationApp.randX(), SimulationApp.randY(), panel);
        panel.spawnCreature("Tiger", SimulationApp.randX(), SimulationApp.randY(), panel);
        panel.spawnCreature("Tiger", SimulationApp.randX(), SimulationApp.randY(), panel);
        panel.spawnCreature("Tiger", SimulationApp.randX(), SimulationApp.randY(), panel);
        populateMicro(panel, 20);

        panel.startSimulation();
    }

    // method to determine a random chance
    public static boolean chance(int chance) {
        final Random random = new Random();
        int randomNumber = random.nextInt(101);
        return randomNumber < chance;
    }

    // method to generate a random X coordinate
    public static int randX() {
        Random random = new Random();
        return random.nextInt(1920+1);
    }

    // method to generate a random y coordinate
    public static int randY() {
        Random random = new Random();
        return random.nextInt(1080+1);
    }

    // NOTES FOR USING populateMicro FUNCTION, DO NOT DELETE!!!
    /**
     * Populates the simulation panel with various types of creatures based on the specified density.
     * 
     * @param panel  The simulation panel where creatures will be spawned.
     * @param density The density factor influencing the likelihood of spawning each creature type.
     *                A higher density increases the chances of spawning creatures.
     * 
     * <p><b>Note:</b> It is recommended not to use a density value beyond 33, as it may lead to 
     * excessive creature spawning and potentially degrade performance.</p>
     */
    static void populateMicro(SimulationPanel panel, int density) {
        for (int i = 0; i<50; i++){
            if(chance(density * 2)){panel.spawnCreature("Fungus", randX(), randY(), panel);}
            if(chance(density)){panel.spawnCreature("Spore", randX(), randY(), panel);}
            if(chance(density * 3)){panel.spawnCreature("Plant", randX(), randY(), panel);}
            if(chance(density/2)){panel.spawnCreature("Seed", randX(), randY(), panel);}
            if(chance(density/2)){panel.spawnCreature("Bacteria", randX(), randY(), panel);}
            if(chance(density/2)){panel.spawnCreature("Virus", randX(), randY(), panel);}
        }
    }
}

class SimulationPanel extends JPanel {
    public int dayTracker = 0;
    private Image bacteriaSprite = createSprite("bacteriaSprite.png"); // creatre the sprite image/s for each organism type
    private Image virusSprite = createSprite("virusSprite.png");
    private Image corpseSprite = createSprite("corpseSprite.png");
    private Image plantSprite = createSprite("plantSprite.png");
    private Image seedSprite = createSprite("seedSprite.png");
    private Image fungusSprite2 = createSprite("fungusSprite2.png");
    private Image sporeSprite = createSprite("sporeSprite.png");
    private Image sporeSpriteLeft = createSprite("sporeSpriteLeft.png");
    private Image sporeSpriteUp = createSprite("sporeSpriteUp.png");
    private Image sporeSpriteDown = createSprite("sporeSpriteDown.png");
    private Image sporeSpriteRight = createSprite("sporeSpriteRight.png");
    private Image tigerSpriteLeft = createSprite("tigerSpriteLeft.png");
    private Image tigerSpriteRight = createSprite("tigerSpriteRight.png");
    private Image gorillaSprite = createSprite("gorillaSprite.png");
    private Image crocodileSprite = createSprite("crocodileSprite.png");
    private Image gasSprite;
    private Image grassBG = createSprite("grassBG.png");
    private Image gorillaDownSprite = createSprite("gorillaDownSprite.png");
    private Image gorillaUpSprite = createSprite("gorillaUpSprite.png");
    private Image gorillaLeftSprite = createSprite("gorillaLeftSprite.png");
    private Image gorillaRightSprite = createSprite("gorillaRightSprite.png");
    private Image crocodileDownSprite = createSprite("crocodileDownSprite.png");
    private Image crocodileUpSprite = createSprite("crocodileUpSprite.png");
    private Image crocodileLeftSprite = createSprite("crocodileLeftSprite.png");
    private Image crocodileRightSprite = createSprite("crocodileRightSprite.png");
    private Image deerSpriteLeft = createSprite("deerSpriteLeft.png");
    private Image deerSpriteRight = createSprite("deerSpriteRight.png");
    private final ArrayList<Organism> creatures = new ArrayList<>();
    private final Random random = new Random();

    public Organism isNear(Organism checkCreature) {
        for (Organism creature : creatures) {
            if (!creature.getID().equals(checkCreature.getID())) {
                int distanceX = Math.abs(creature.getX() - checkCreature.getX());
                int distanceY = Math.abs(creature.getY() - checkCreature.getY());
                if (distanceX <= 75 && distanceY <= 75) {
                    return creature;
                    }
                }
            }
        return null;
    }

    // Custom JPanel for the image overlay
    class ImageOverlayPanel extends JPanel {
        private ImageIcon gifIcon;
        private float opacity;
    
        public ImageOverlayPanel(String gifPath, float opacity) {
            this.opacity = opacity;
            try {
                //Loads GIF
                gifIcon = new ImageIcon(getClass().getResource("/img/" + gifPath));
            } catch (Exception e) {
                e.printStackTrace();
            }
            setOpaque(false); // Make the panel transparent
        }
    
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (gifIcon != null) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
    
                g2d.drawImage(gifIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
    
                //Adds a semi-transparent white overlay to brighten the GIF
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.2f)); // Adjust the alpha for brightness
                g2d.setColor(new Color(255, 255, 255)); // White color
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        }
        
    }

    public void test() {
        ArrayList<Organism> creatures1 = new ArrayList<>(creatures);
        for (Organism creature1 : creatures1) {
            Organism creature2 = isNear(creature1);
            //collision handling
            if (creature2 != null && (!(creature1.isPaused())) && (!(creature2.isPaused()))) {
                switch (creature1.getClass().getSimpleName() + "-" + creature2.getClass().getSimpleName()) {

                    // ORGANISM INTERACTION CASES ---------------------------------------------------------------------------------------------------------------------------------------------------------------

                    case "Crocodile-Gorilla":
                    case "Gorilla-Crocodile":

                    if ((((Animal) creature1).getStrength() > ((Animal) creature2).getStrength()) && creature1.getHunger() > 30) {       // if creature1 stronger than creature2 AND creature1 hunger over 30...
                        ((Animal) creature1).eat(creature2);
                        creatures.remove(creature2);
                        creature1.pauseInteractions();
                    } else if ((((Animal) creature1).getStrength() == ((Animal) creature2).getStrength())) {    // if strengths are equal...
                        if (creature1.getHunger() > 30 && creature2.getHunger() > 30) {                         // if both creatures hunger > 30, one lives, one dies
                            if (new Random().nextBoolean()) {
                                ((Animal) creature1).eat(creature2);
                                creatures.remove(creature2);
                                creature1.pauseInteractions();
                            } else {
                                ((Animal) creature2).eat(creature1);
                                creatures.remove(creature1);
                                creature2.pauseInteractions();
                            }
                        } else if (creature1.getHunger() > 30) {            // if only creature1 hunger is over 30, 50% chance to eat creature2
                            if (new Random().nextBoolean()) {
                                ((Animal) creature1).eat(creature2);
                                creatures.remove(creature2);
                                creature1.pauseInteractions();
                            }
                        } else if (creature2.getHunger() > 30) {            // if only creature2 hunger is over 30, 50% chance to eat creature1
                            if (new Random().nextBoolean()) {
                                ((Animal) creature2).eat(creature1);
                                creatures.remove(creature1);
                                creature2.pauseInteractions();
                            }
                        }
                    } else if ((((Animal) creature2).getStrength() > ((Animal) creature2).getStrength()) && creature2.getHunger() > 30) {    // if creature2 stronger than creature1 AND creature2 hunger over 30...
                        ((Animal) creature2).eat(creature1);
                        creatures.remove(creature1);
                        creature2.pauseInteractions();
                    }
                    break;

                    case "Tiger-Fungus":
                    case "Fungus-Tiger":
                        // Define interaction between Tiger and Fungus
                        break;

                    case "Gorilla-Plant":
                    case "Plant-Gorilla":
                    Organism gorilla = (creature1 instanceof Gorilla) ? creature1 : creature2;
                    Organism plant = (creature1 instanceof Plant) ? creature1 : creature2;

                    if (gorilla.getHunger() > 30) {     // if gorilla hunger over 30, eat plant
                        ((Animal)gorilla).eat(plant);
                        plant.decreaseSize(90);
                        if (plant.getSize() < 0) {
                            creatures.remove(plant);
                        }
                    }
                    break;

                    case "Crocodile-Tiger":
                    case "Tiger-Crocodile":

                    if ((((Animal) creature1).getStrength() > ((Animal) creature2).getStrength()) && creature1.getHunger() > 30) {       // if creature1 stronger than creature2 AND creature1 hunger over 30...
                        ((Animal) creature1).eat(creature2);
                        creatures.remove(creature2);
                        creature1.pauseInteractions();
                    } else if ((((Animal) creature1).getStrength() == ((Animal) creature2).getStrength())) {    // if strengths are equal...
                        if (creature1.getHunger() > 30 && creature2.getHunger() > 30) {                         // if both creatures hunger > 30, one lives, one dies
                            if (new Random().nextBoolean()) {
                                ((Animal) creature1).eat(creature2);
                                creatures.remove(creature2);
                                creature1.pauseInteractions();
                            } else {
                                ((Animal) creature2).eat(creature1);
                                creatures.remove(creature1);
                                creature2.pauseInteractions();
                            }
                        } else if (creature1.getHunger() > 30) {            // if only creature1 hunger is over 30, 50% chance to eat creature2
                            if (new Random().nextBoolean()) {
                                ((Animal) creature1).eat(creature2);
                                creatures.remove(creature2);
                                creature1.pauseInteractions();
                            }
                        } else if (creature2.getHunger() > 30) {            // if only creature2 hunger is over 30, 50% chance to eat creature1
                            if (new Random().nextBoolean()) {
                                ((Animal) creature2).eat(creature1);
                                creatures.remove(creature1);
                                creature2.pauseInteractions();
                            }
                        }
                    } else if ((((Animal) creature2).getStrength() > ((Animal) creature2).getStrength()) && creature2.getHunger() > 30) {    // if creature2 stronger than creature1 AND creature2 hunger over 30...
                        ((Animal) creature2).eat(creature1);
                        creatures.remove(creature1);
                        creature2.pauseInteractions();
                    }
                    break;

                    case "Crocodile-Fungus":
                    case "Fungus-Crocodile":
                        // Define interaction between Crocodile and Fungus
                        break;

                    case "Gorilla-Tiger":
                    case "Tiger-Gorilla":

                    if ((((Animal) creature1).getStrength() > ((Animal) creature2).getStrength()) && creature1.getHunger() > 30) {       // if creature1 stronger than creature2 AND creature1 hunger over 30...
                        ((Animal) creature1).eat(creature2);
                        creatures.remove(creature2);
                        creature1.pauseInteractions();
                    } else if ((((Animal) creature1).getStrength() == ((Animal) creature2).getStrength())) {    // if strengths are equal...
                        if (creature1.getHunger() > 30 && creature2.getHunger() > 30) {                         // if both creatures hunger > 30, one lives, one dies
                            if (new Random().nextBoolean()) {
                                ((Animal) creature1).eat(creature2);
                                creatures.remove(creature2);
                                creature1.pauseInteractions();
                            } else {
                                ((Animal) creature2).eat(creature1);
                                creatures.remove(creature1);
                                creature2.pauseInteractions();
                            }
                        } else if (creature1.getHunger() > 30) {            // if only creature1 hunger is over 30, 50% chance to eat creature2
                            if (new Random().nextBoolean()) {
                                ((Animal) creature1).eat(creature2);
                                creatures.remove(creature2);
                                creature1.pauseInteractions();
                            }
                        } else if (creature2.getHunger() > 30) {            // if only creature2 hunger is over 30, 50% chance to eat creature1
                            if (new Random().nextBoolean()) {
                                ((Animal) creature2).eat(creature1);
                                creatures.remove(creature1);
                                creature2.pauseInteractions();
                            }
                        }
                    } else if ((((Animal) creature2).getStrength() > ((Animal) creature2).getStrength()) && creature2.getHunger() > 30) {    // if creature2 stronger than creature1 AND creature2 hunger over 30...
                        ((Animal) creature2).eat(creature1);
                        creatures.remove(creature1);
                        creature2.pauseInteractions();
                    }
                    break;

                    case "Gorilla-Fungus":
                    case "Fungus-Gorilla":
                        Organism gorilla1 = (creature1 instanceof Gorilla) ? creature1 : creature2;
                        Organism fungus = (creature1 instanceof Fungus) ? creature1 : creature2;

                        if (gorilla1.getHunger() > 30) {   // if gorilla hunger over 30, eat fungus
                            ((Animal)gorilla1).eat(fungus);
                            fungus.decreaseSize(90);
                            if (fungus.getSize() < 0) {
                                creatures.remove(fungus);
                            }
                        }
                        break;
                    
                    case "Gorilla-Gorilla":
                        if ((creature1.getHunger() < 60) && (creature2.getHunger() < 60) && (creature1.getAge() > 25) && (creature2.getAge() > 25)) {
                            if (new Random().nextBoolean()) {
                                reproduce(creature1);
                                creature1.setHunger(60);
                                creature2.setHunger(60);
                                creature1.pauseInteractions();
                                creature2.pauseInteractions();
                            }
                        }
                        break;

                    case "Tiger-Tiger":
                        if ((creature1.getHunger() < 60) && (creature2.getHunger() < 60) && (creature1.getAge() > 25) && (creature2.getAge() > 25)) {
                            if (new Random().nextBoolean()) {
                                reproduce(creature1);
                                creature1.setHunger(60);
                                creature2.setHunger(60);
                                creature1.pauseInteractions();
                                creature2.pauseInteractions();
                            }
                        }
                        break;

                    case "Crocodile-Crocodile":
                        if ((creature1.getHunger() < 60) && (creature2.getHunger() < 60) && (creature1.getAge() > 25) && (creature2.getAge() > 25)) {
                            if (new Random().nextBoolean()) {
                                reproduce(creature1);
                                creature1.setHunger(60);
                                creature2.setHunger(60);
                                creature1.pauseInteractions();
                                creature2.pauseInteractions();
                            }
                        }
                        break;

                    case "Deer-Deer":
                        if ((creature1.getHunger() < 60) && (creature2.getHunger() < 60) && (creature1.getAge() > 10) && (creature2.getAge() > 10)) {
                            if (new Random().nextBoolean()) {
                                reproduce(creature1);
                                creature1.setHunger(60);
                                creature2.setHunger(60);
                                creature1.pauseInteractions();
                                creature2.pauseInteractions();
                            }
                        }
                        break;

                    case "Deer-Gorilla":
                    case "Gorilla-Deer":
                        Organism deer = (creature1 instanceof Deer) ? creature1 : creature2;
                        Organism gorilla2 = (creature1 instanceof Gorilla) ? creature1 : creature2;

                        if (gorilla2.getHunger() > 30) { // if gorilla hunger over 30, eat deer
                            ((Animal) gorilla2).eat(deer);
                            creatures.remove(deer);
                            gorilla2.pauseInteractions();
                        }
                        break;

                    case "Deer-Crocodile":
                    case "Crocodile-Deer":
                        Organism deer2 = (creature1 instanceof Deer) ? creature1 : creature2;
                        Organism crocodile = (creature1 instanceof Crocodile) ? creature1 : creature2;

                        if (crocodile.getHunger() > 30) { // if crocodile hunger over 30, eat deer
                            ((Animal) crocodile).eat(deer2);
                            creatures.remove(deer2);
                            crocodile.pauseInteractions();
                        }
                        break;

                    case "Deer-Tiger":
                    case "Tiger-Deer":
                        Organism deer3 = (creature1 instanceof Deer) ? creature1 : creature2;
                        Organism tiger = (creature1 instanceof Tiger) ? creature1 : creature2;

                        if (tiger.getHunger() > 30) { // if tiger hunger over 30, eat deer
                            ((Animal) tiger).eat(deer3);
                            creatures.remove(deer3);
                            tiger.pauseInteractions();
                        }
                        break;

                    case "Deer-Plant":
                    case "Plant-Deer":
                        Organism deer4 = (creature1 instanceof Deer) ? creature1 : creature2;
                        Organism plant1 = (creature1 instanceof Plant) ? creature1 : creature2;

                        if (deer4.getHunger() > 30) { // if deer hunger over 30, eat plant
                            ((Animal) deer4).eat(plant1);
                            plant1.decreaseSize(90);
                            if (plant1.getSize() < 0) {
                                creatures.remove(plant1);
                            }
                        }
                        break;

                    case "Deer-Fungus":
                    case "Fungus-Deer":
                        Organism deer5 = (creature1 instanceof Deer) ? creature1 : creature2;
                        Organism fungus2 = (creature1 instanceof Fungus) ? creature1 : creature2;

                        if (deer5.getHunger() > 30) { // if deer hunger over 30, eat fungus
                            ((Animal) deer5).eat(fungus2);
                            fungus2.decreaseSize(90);
                            if (fungus2.getSize() < 0) {
                                creatures.remove(fungus2);
                            }
                        }
                        break;

                    case "Virus-Gorilla":
                    case "Gorilla-Virus":
                        // Define interaction between Virus and Gorilla
                        break;

                    case "Virus-Crocodile":
                    case "Crocodile-Virus":
                        // Define interaction between Virus and Crocodile
                        break;

                    case "Virus-Tiger":
                    case "Tiger-Virus":
                        // Define interaction between Virus and Tiger
                        break;

                    case "Bacteria-Gorilla":
                    case "Gorilla-Bacteria":
                        // Define interaction between Bacteria and Gorilla
                        break;

                    case "Bacteria-Crocodile":
                    case "Crocodile-Bacteria":
                        // Define interaction between Bacteria and Crocodile
                        break;

                    case "Bacteria-Tiger":
                    case "Tiger-Bacteria":
                        // Define interaction between Bacteria and Tiger
                        break;

                    case "Corpse-Gorilla":
                    case "Gorilla-Corpse":
                        // Define interaction between Corpse and Gorilla
                        break;

                    case "Corpse-Crocodile":
                    case "Crocodile-Corpse":
                        // Define interaction between Corpse and Crocodile
                        break;

                    case "Corpse-Tiger":
                    case "Tiger-Corpse":
                        // Define interaction between Corpse and Tiger
                        break;

                    case "Corpse-Bacteria":
                    case "Bacteria-Corpse":
                        // Define interaction between Corpse and Bacteria
                        break;

                    case "Seed-Corpse":
                    case "Corpse-Seed":
                        // When seed meets corpse, seed "consumes" corpse to become plant
                        int plantX = 0;
                        int plantY = 0;
                        if (creature1 instanceof Corpse) {
                            plantX = creature1.getX();
                            plantY = creature1.getY();
                        } else {
                            plantX = creature2.getX();
                            plantY = creature2.getY();
                        }
                        Plant newPlant = new Plant();
                        newPlant.setX(plantX);
                        newPlant.setY(plantY);
                        creatures.add(newPlant);
                        creatures.remove(creature1);
                        creatures.remove(creature2);
                        break;

                    case "Spore-Corpse":
                    case "Corpse-Spore":
                        // When spore meets corpse, spore "consumes" corpse to become fungus
                    int newX = 0; 
                    int newY = 0; 
                    if (creature1 instanceof Corpse) {
                        newX = creature1.getX();
                        newY = creature1.getY();
                    }
                    else {
                        newX = creature2.getX();
                        newY = creature2.getY();
                    }
                    Fungus newFungus = new Fungus();
                    newFungus.setX(newX);
                    newFungus.setY(newY);
                    creatures.add(newFungus);
                    creatures.remove(creature1);
                    creatures.remove(creature2);
                    break;

                    case "Crocodile-Plant":
                    case "Plant-Crocodile":
                    case "Tiger-Plant":
                    case "Plant-Tiger":
                    case "Virus-Plant":
                    case "Plant-Virus":
                    case "Virus-Fungus":
                    case "Fungus-Virus":
                    case "Bacteria-Plant":
                    case "Plant-Bacteria":
                    case "Bacteria-Fungus":
                    case "Fungus-Bacteria":
                    case "Corpse-Plant":
                    case "Plant-Corpse":
                    case "Corpse-Fungus":
                    case "Fungus-Corpse":
                    case "Corpse-Virus":
                    case "Virus-Corpse":
                    case "Virus-Bacteria":
                    case "Bacteria-Virus":
                    case "Plant-Seed":
                    case "Seed-Plant":
                    case "Fungus-Spore":
                    case "Spore-Fungus":
                    case "Seed-Fungus":
                    case "Fungus-Seed":
                    case "Seed-Spore":
                    case "Spore-Seed":
                    case "Plant-Spore":
                    case "Spore-Plant":
                    case "Plant-Fungus":
                    case "Fungus-Plant":
                    case "Spore-Spore":
                    case "Seed-Seed":
                    case "Plant-Plant":
                    case "Fungus-Fungus":
                        // no interaction
                        break;

                    default:
                        // System.err.println("ERROR: Interaction does not exist for " + creature1.getID() + " and " + creature2.getID()); // error message if interaction is invalid (FOR TESTING)
                        break;
                }
            }
        }
    }
    
    public void becomeCorpse(Organism creature1) {
    if (creature1 instanceof Corpse) {
        return;
    }
    int index = creatures.indexOf(creature1);
    Corpse corpse = new Corpse();
    corpse.setX(creature1.getX());
    corpse.setY(creature1.getY());
    creatures.set(index, corpse);
    System.out.println(creature1.getID() + " starved!");
    }

    public void addCreature(Organism creature) {
        creatures.add(creature);
        System.out.println("Added creature: " + creature.getClass().getSimpleName() + " at (" + creature.getX() + ", " + creature.getY() + ")");
    }

    public void reproduce(Organism creatureToReproduce) {
        switch (creatureToReproduce.getClass().getSimpleName()) {
            case "Fungus":
            // Logic for reproducing Fungus
            Spore newSpore = new Spore();
            newSpore.setX(creatureToReproduce.getX() + 10);
            newSpore.setY(creatureToReproduce.getY() + 10);
            creatures.add(newSpore);
            System.out.println(creatureToReproduce.getID() + " reproduced!");
            break;

            case "Plant":
            // Logic for reproducing Plant
            Seed newSeed = new Seed();
            newSeed.setX(creatureToReproduce.getX() + 10);
            newSeed.setY(creatureToReproduce.getY() + 10);
            creatures.add(newSeed);
            System.out.println(creatureToReproduce.getID() + " reproduced!");
            break;

            case "Gorilla":
            // Logic for reproducing Gorilla
            Gorilla newGorilla = new Gorilla();
            newGorilla.setX(creatureToReproduce.getX() + 20);
            newGorilla.setY(creatureToReproduce.getY() + 20);
            creatures.add(newGorilla);
            System.out.println(creatureToReproduce.getID() + " reproduced!");
            break;

            case "Tiger":
            // Logic for reproducing Tiger
            Tiger newTiger = new Tiger();
            newTiger.setX(creatureToReproduce.getX() + 20);
            newTiger.setY(creatureToReproduce.getY() + 20);
            creatures.add(newTiger);
            System.out.println(creatureToReproduce.getID() + " reproduced!");
            break;

            case "Crocodile":
            // Logic for reproducing Crocodile
            Crocodile newCrocodile = new Crocodile();
            newCrocodile.setX(creatureToReproduce.getX() + 20);
            newCrocodile.setY(creatureToReproduce.getY() + 20);
            creatures.add(newCrocodile);
            System.out.println(creatureToReproduce.getID() + " reproduced!");
            break;

            case "Deer":
            Deer newDeer = new Deer();
            newDeer.setX(creatureToReproduce.getX() + 20);
            newDeer.setY(creatureToReproduce.getY() + 20);
            creatures.add(newDeer);
            System.out.println(creatureToReproduce.getID() + " reproduced!");
            break;

            default:
            System.out.println("Reproduction logic not defined for: " + creatureToReproduce.getClass().getSimpleName());
            break;
        }
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
            newCreature = new Tiger();
            break;

            case "Crocodile":
            newCreature = new Crocodile();
            break;

            case "Gorilla":
            newCreature = new Gorilla();
            break;

            case "Deer":
            newCreature = new Deer();
            break;

            default:
            System.out.println("Unknown type: " + type);
            break;

        }
        newCreature.setX(x);
        newCreature.setY(y);
        panel.addCreature(newCreature);
    }

    public void incrementTime() {              // anything in here will be run every 5 seconds
        ArrayList<Organism> creaturesCopy = new ArrayList<>(creatures);
        dayTracker++;
        System.out.println("\n----------------Day " + dayTracker + "----------------");

        for (Organism creature : creaturesCopy) {

            creature.increaseAge(1);
            
            if (creature instanceof Animal) {     // applies only to animals
                if (creature instanceof Crocodile) {
                    creature.increaseHunger(2); // crocodiles gain 2 hunger (dies after 50 days without food)
                } else if (creature instanceof Tiger) {
                    creature.increaseHunger(3); // tigers gain 3 hunger (dies after 30 days without food)
                }  else {
                    creature.increaseHunger(4); // everything else gains 4 hunger (dies after 25 days without food)
                }
                if (creature.getHunger() > 84 && ((Animal)creature).getStrength() > 45 && !(creature instanceof Deer)) {
                    ((Animal)creature).setStrength(45);  // reduce strength to 45 if hunger greater than 84
                }
                if (creature.getHunger() < 85 && ((Animal)creature).getStrength() < 90 && !(creature instanceof Deer)) {
                    ((Animal)creature).setStrength(90);  // return strength to 90 if hunger was satisfied
                }
                if (creature.getHunger() > 100 || creature.getAge() > 160) { // if animal hunger exceeds 100, or age exceeds 160 days, animal becomes corpse (dies)
                    becomeCorpse(creature);
                }
            }
            else if (!(creature instanceof Animal)) { // if creature is not instance of Animal
                if ((creature instanceof Plant) || (creature instanceof Fungus)) { // if plant or fungus...
                    int randomGrowth = new Random().nextInt(2); // Generate a random number between 0 and 1
                    creature.increaseSize(randomGrowth); // grow plant/fungus size by random amount
                    if (creature.getSize() > 120) {  // creature reproduces (seed or spore) when size is over 100 (every 50 seconds or so)
                        reproduce(creature);
                        creature.decreaseSize(70);
                    }
                }
                else if (creature instanceof Seed) {
                    if (creature.getAge() > 25) {
                        Plant newPlant = new Plant();
                        newPlant.setX(creature.getX());
                        newPlant.setY(creature.getY());
                        creatures.add(newPlant);
                        creatures.remove(creature);
                    }
                }
                else if (creature instanceof Spore) {
                    if (creature.getAge() > 25) {
                        Fungus newFungus = new Fungus();
                        newFungus.setX(creature.getX());
                        newFungus.setY(creature.getY());
                        creatures.add(newFungus);
                        creatures.remove(creature);
                    }
                }
                
            }
            if (creature.isPaused()) {     // resume any paused creatures
            creature.resumeInteractions();
            }
        } 
        String[] types = {"Spore", "Seed", "Deer"};
        for (String type : types) {
            long count = creatures.stream().filter(creature -> creature.getClass().getSimpleName().equals(type)).count();
            if (type.equals("Spore")) {
            long fungusCount = creatures.stream().filter(creature -> creature instanceof Fungus).count();
            if (count < 5 && fungusCount < 12 && new Random().nextInt(2) == 0) { // 1/2 chance to spawn if conditions met
                spawnCreature(type, SimulationApp.randX(), SimulationApp.randY(), this);
            }
            } else if (type.equals("Seed")) {
            long plantCount = creatures.stream().filter(creature -> creature instanceof Plant).count();
            if (count < 5 && plantCount < 12 && new Random().nextInt(2) == 0) { // 1/2 chance to spawn if conditions met
                spawnCreature(type, SimulationApp.randX(), SimulationApp.randY(), this);
            }
            } else if (type.equals("Deer")) {
            if (count < 10 && new Random().nextInt(4) == 0) { // 1/4 chance to spawn if less than 10 exist
                spawnCreature(type, SimulationApp.randX(), SimulationApp.randY(), this);
            }
            }
        }

        String[] creatureTypes = {"Crocodile", "Tiger", "Gorilla"};
        for (String type : creatureTypes) {
            long count = creatures.stream().filter(creature -> creature.getClass().getSimpleName().equals(type)).count();
            if (count < 5 && new Random().nextInt(6) == 0) { // 1/6 chance to spawn if less than 5 exist
            spawnCreature(type, SimulationApp.randX(), SimulationApp.randY(), this);
            }
        }
    }

    public String getStats(Organism creature) {
        int age = creature.getAge();
        int hunger = creature.getHunger();
        int health = creature.getHealth();
        String ID = creature.getID();
        int size = creature.getSize();

        return "ID: " + ID + ", Age: " + age + ", Hunger: " + hunger + ", Health: " + health + ", Size: " + size;
    }

    public void startSimulation() {
        int movechance = 3; // chance (out of 100) of moving directions in given tick
        int speed = 1; //this will probably be an attribute of organism class in the future

        Timer movementTimer = new Timer(12, e -> { // runs at 83fps
            // Update creature positions
            for (Organism creature : creatures) {
                if (creature.canMove()){
                if (random.nextInt(100) < movechance) {
                    //Change direction based on movechance
                    creature.setDx(random.nextInt(3) - 1);
                    creature.setDy(random.nextInt(3) - 1);
                }
                // Update position based on dx and dy
                int newX = creature.getX() + creature.getDx() * speed;
                int newY = creature.getY() + creature.getDy() * speed;
                
                //ensure boundaries
                newX = Math.max(0, Math.min(getWidth() - creature.getSize(), newX));
                newY = Math.max(0, Math.min(getHeight() - creature.getSize(), newY));
                //Update creature pos
                creature.setX(newX);
                creature.setY(newY);
                }
            }
            
            // Repaint the panel
            test();
            repaint();
        });
        movementTimer.start();
        Timer incrementTimeTimer = new Timer(2750, e -> { // runs every 2.75 seconds
            incrementTime();                                            
        });
        incrementTimeTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw background
        g.setColor(Color.WHITE);
        g.drawImage(grassBG, 0, 0, getWidth(), getHeight(), this);

        // Draw creatures
        for (Organism creature : creatures) {
            draw(g, creature.getX(), creature.getY(), creature);
        }
    }

    private void showMessage(String text, int x, int y){
        JLabel messageLabel = new JLabel(text, SwingConstants.CENTER);
        messageLabel.setBounds(x, y, 300, 100);
        messageLabel.setOpaque(true); 
        messageLabel.setBackground(new Color(255, 255, 200));
        messageLabel.setForeground(Color.BLACK); 
        messageLabel.setFont(new Font("Arial", Font.BOLD, 16));
        messageLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.add(messageLabel);
        this.repaint();

        Timer timer = new Timer(2000, e -> {
            this.remove(messageLabel);
            this.repaint();
        });
        timer.setRepeats(false);
        timer.start();
    }

    private void draw(Graphics g, int x, int y, Organism creature) {

        if (creature instanceof Fungus) {
            // Use the sprite image for Fungus
            if (fungusSprite2 != null) {
            g.drawImage(fungusSprite2, x, y, creature.getSize(), creature.getSize(), this);
            } else {
            g.setColor(Color.CYAN);
            g.fillRect(x, y, creature.getSize(), creature.getSize());
            }

        } else if (creature instanceof Spore) {
            // Use the sprite image for Spore
            if (sporeSprite != null) {
                    switch (creature.getDx()) {
                        case 1:
                            g.drawImage(sporeSpriteRight, x, y, creature.getSize(), creature.getSize(), this);
                            break;
                        case -1:
                            g.drawImage(sporeSpriteLeft, x, y, creature.getSize(), creature.getSize(), this);
                            break;
                        case 0:
                        switch (creature.getDy()) {
                            case 1:
                                g.drawImage(sporeSpriteDown, x, y, creature.getSize(), creature.getSize(), this);
                                break;
                            case -1:
                                g.drawImage(sporeSpriteUp, x, y, creature.getSize(), creature.getSize(), this);
                                break;
                            default:
                                g.drawImage(sporeSprite, x, y, creature.getSize(), creature.getSize(), this);
                                break;
                        }
                }
            } else {
            g.setColor(Color.YELLOW);
            g.fillOval(x, y, creature.getSize(), creature.getSize());
            }

        } else if (creature instanceof Plant) {
            // Use the sprite image for Plant
            if (plantSprite != null) {
            g.drawImage(plantSprite, x, y, creature.getSize(), creature.getSize(), this);
            } else {
            g.setColor(Color.GREEN);
            g.fillRoundRect(x, y, creature.getSize(), creature.getSize(), 10, 10);
            }
            
        } else if (creature instanceof Seed) {
            // Use the sprite image for Seed
            if (seedSprite != null) {
            g.drawImage(seedSprite, x, y, creature.getSize(), creature.getSize(), this);
            } else {
            g.setColor(Color.ORANGE);
            g.fillOval(x, y, creature.getSize(), creature.getSize());
            }

        } else if (creature instanceof Bacteria) {
            // Use the sprite image for Bacteria
            if (bacteriaSprite != null) {
            g.drawImage(bacteriaSprite, x, y, creature.getSize(), creature.getSize(), this);
            } else {
            g.setColor(Color.GRAY);
            g.fillOval(x, y, creature.getSize(), creature.getSize());
            }

        } else if (creature instanceof Virus) {
            // Use the sprite image for Virus
            if (virusSprite != null) {
            g.drawImage(virusSprite, x, y, creature.getSize(), creature.getSize(), this);
            } else {            
            g.setColor(Color.BLACK);
            g.fillRect(x, y, creature.getSize(), creature.getSize());
            }

        } else if (creature instanceof Corpse) {
            // Use the sprite image for Corpse
            if (corpseSprite != null) {
            g.drawImage(corpseSprite, x, y, creature.getSize() * 2, creature.getSize(), this);
            } else {
            g.setColor(Color.DARK_GRAY);
            g.fillOval(x, y, creature.getSize(), creature.getSize());
            } 

        } else if (creature instanceof Tiger) {
                // Use the sprite image for Tiger
            if (tigerSpriteLeft != null && tigerSpriteRight != null) {
            switch (creature.getDx()) {
                case 1:
                g.drawImage(tigerSpriteRight, x, y, creature.getSize(), (int)(creature.getSize() * 0.75), this);
                break;
                case -1:
                g.drawImage(tigerSpriteLeft, x, y, creature.getSize(), (int)(creature.getSize() * 0.75), this);
                break;
                default:
                g.drawImage(tigerSpriteRight, x, y, creature.getSize(), (int)(creature.getSize() * 0.75), this);
                break;
            }
            } else {
            g.setColor(Color.ORANGE);
            g.fillRect(x, y, creature.getSize(), creature.getSize());
            }

        } else if (creature instanceof Gorilla) {
            // Use the sprite image for Gorilla
            if (gorillaSprite != null) {
                switch (creature.getDx()) {
                    case 1:
                        g.drawImage(gorillaRightSprite, x, y, creature.getSize(), creature.getSize(), this);
                        break;
                    case -1:
                        g.drawImage(gorillaLeftSprite, x, y, creature.getSize(), creature.getSize(), this);
                        break;
                    case 0:
                    switch (creature.getDy()) {
                        case 1:
                            g.drawImage(gorillaDownSprite, x, y, creature.getSize(), creature.getSize(), this);
                            break;
                        case -1:
                            g.drawImage(gorillaUpSprite, x, y, creature.getSize(), creature.getSize(), this);
                            break;
                        default:
                            g.drawImage(gorillaSprite, x, y, creature.getSize(), creature.getSize(), this);
                            break;
                    }
                }
            }
        } 
        
        else if (creature instanceof Deer) {
            // Use the sprite image for Deer
            if (deerSpriteLeft != null && deerSpriteRight != null) {
                switch (creature.getDx()) {
                    case 1:
                        g.drawImage(deerSpriteRight, x, y, creature.getSize(), creature.getSize(), this);
                        break;
                    case -1:
                        g.drawImage(deerSpriteLeft, x, y, creature.getSize(), creature.getSize(), this);
                        break;
                    default:
                        g.drawImage(deerSpriteRight, x, y, creature.getSize(), creature.getSize(), this);
                        break;
                }
            } else {
                g.setColor(new Color(139, 69, 19)); // Brown color
                g.fillRect(x, y, creature.getSize(), creature.getSize());
            }
        }

        
        else if (creature instanceof Crocodile) {
                switch (creature.getDx()) {
                    case 1:
                        g.drawImage(crocodileRightSprite, x, y, creature.getSize(), creature.getSize()/2, this);
                        break;
                    case -1:
                        g.drawImage(crocodileLeftSprite, x, y, creature.getSize(), creature.getSize()/2, this);
                        break;
                    case 0:
                switch (creature.getDy()) {
                    case 1:
                        g.drawImage(crocodileDownSprite, x, y, creature.getSize(), creature.getSize(), this);
                        break;
                    case -1:
                        g.drawImage(crocodileUpSprite, x, y, creature.getSize(), creature.getSize(), this);
                        break;
                    default:
                        g.drawImage(crocodileSprite, x, y, creature.getSize(), creature.getSize(), this);
                        break;
                    }
                }
        }

      

    }
}
