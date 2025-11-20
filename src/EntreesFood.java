
import java.util.Objects;
import javax.swing.ImageIcon;

public class EntreesFood {

    public Food chips;
    public Food calamari;
    public Food scallops;
    public Food fries;
    public Food frys;
    public Food macNCheese;
    public Food chickenNuggets;
    public Food shrimp;
    

    public EntreesFood(){
        chips = new Food("Chip Platter", 5.00, 150, "Exhuberantly delicate crisps held in a bag, presented on a silver platter", 5, new ImageIcon((Objects.requireNonNull(getClass().getResource("img/Chip Platter.png")))));
        calamari = new Food("Calamari Box", 9.75, 110, "Squid in a box.", 5, new ImageIcon((Objects.requireNonNull(getClass().getResource("img/Calamari.png")))));
        scallops = new Food("Scallops bag", 14.25, 140, "...its literally just scallops... in a bag...", 5, new ImageIcon((Objects.requireNonNull(getClass().getResource("img/Scallops.png")))));
        fries = new Food("Fries", 5.00, 150, "This perfect blend of salt and pomme de terre creates a simple yet exhilerating taste.", 5, new ImageIcon((Objects.requireNonNull(getClass().getResource("img/fries.png")))));
        frys = new Food("Frys", 7.00, 100, "Put the frys in the bag and eat a family of young eels!", 5, new ImageIcon((Objects.requireNonNull(getClass().getResource("img/Frys.png")))));
        macNCheese = new Food("Fromage Pasta ", 3.00, 175, "A bowl of indubitubly delicious, cheesy, and creamy pasta, with a soft texture perfect for people of all ages", 5, new ImageIcon((Objects.requireNonNull(getClass().getResource("img/MacAndCheese.png")))));
        chickenNuggets = new Food("Chicken Bits", 2.50, 200, "A decorated display of of chicken claimed as masterPIECES.", 5, new ImageIcon((Objects.requireNonNull(getClass().getResource("img/ChickenNugget.png")))));
        shrimp = new Food("Fried shrimp", 7.50, 100, "smol shrimpies.", 5, new ImageIcon((Objects.requireNonNull(getClass().getResource("img/Shrimp.png")))));
    }

    public void sellEntree(Food entree) {
        entree.setNumAvailable(entree.getNumAvailable() - 1);
    }

    
    public String toString(Food entree) {
        return ("A " + entree.getName() + " costs $" + entree.getPrice() + ". " + entree.getDescription() + " Calories: " + entree.getCalories() + ". Available: " + entree.getNumAvailable());
    }

}
