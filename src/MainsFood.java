import java.util.Objects;
import javax.swing.ImageIcon;

public class MainsFood {

    // public Food Food_name = new Food(String name, double price, int calories, String description, int avalibility)
    public Food hamburger = new Food("Hamburger", 6.00, 800, "juicy beed patty with condiments that is between 2 buns", 10, new ImageIcon((Objects.requireNonNull(getClass().getResource("img/Hamburger.png")))));
    public Food cheeseburger = new Food("Cheeseburger", 5.00, 600, "juicy beef paty with only cheese and sauce between 2 buns", 10, new ImageIcon((Objects.requireNonNull(getClass().getResource("img/name.png")))));
    public Food hotdog = new Food("Hotdog", 4.00, 400, "grilled sausage in a bun with condiments", 10, new ImageIcon((Objects.requireNonNull(getClass().getResource("img/Hotdog.png")))));
    public Food pizza = new Food("Pizza", 8.00, 900, "sliced pizza with pepperoni and cheese", 10, new ImageIcon((Objects.requireNonNull(getClass().getResource("img/name.png")))));
    public Food tacos = new Food("Tacos", 7.00, 700, "5 soft shell tacos with beef, lettuce, cheese, and condiments", 10, new ImageIcon((Objects.requireNonNull(getClass().getResource("img/Taco.png")))));
    public Food pasta = new Food("Pasta", 9.00, 850, "spaghetti pasta with marinara sauce and meatballs", 10, new ImageIcon((Objects.requireNonNull(getClass().getResource("img/name.png")))));
    public Food turkeySandwich = new Food("Turkey Sandwich", 6.50, 650, "sliced turkey breast with lettuce, tomato, and condiments on whole wheat bread", 10, new ImageIcon((Objects.requireNonNull(getClass().getResource("img/name.png")))));
    public Food grilledCheese = new Food("Grilled Cheese", 4.50, 500, "melted cheese between 2 slices of buttered grilled bread", 10, new ImageIcon((Objects.requireNonNull(getClass().getResource("img/name.png")))));
    


}
