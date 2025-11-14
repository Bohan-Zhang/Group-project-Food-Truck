public class Drink {
    private String name;
    private double price;
    private int calories;
    private String description;
    private int numAvailable;
    public Drink redGlass = new Drink("Red Wineglass", 13.50, 133, "A Glass of Merlot", 20);
    public Drink redBottle = new Drink("Red Winebottle", 29.99, 295,"A Full Bottle of Merlot for you to take home", 10);
    public Drink whiteGlass = new Drink("White Wineglass", 9.99, 120, "A Glass of Chardonnay", 20);
    public Drink WhiteBottle = new Drink("White Winebottle", 22.18, 266, "A Full Bottle of Chardonnay for you to take home");
    public Drink citrusSplash = new Drink("Citrus Splash", 9.50, 50, "A sweet, refreshing drink made from mixed citrus juices like orange, tangerine, grapefruit, and lime.");
    public Drink berryBreeze = new Drink("Berry Breeze", 2.50, 70, "A fruity, refreshing drink made from a blend of mixed berries like strawberry, blueberry, and raspberry.");
    public Drink pinaColada = new Drink("Piña Colada", 3.00, 120, "A sweet, creamy drink made with pineapple and coconut.");
    public Drink tequila = new Drink("Tequila", 7.50, 330, "A strong, clear spirit made from the blue agave plant in Mexico.");
    public Drink(String n, double p, int c, String d, int a) {
        name = n;
        price = p;
        calories = c;
        description = d;
        numAvailable = a;
    }
    
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getCalories() {
        return calories;
    }
    public String getDescription() {
        return description;
    }
    
    public int getNumAvailable() {
        return numAvailable;
    }


    public void setNumAvailable(int num) {
        numAvailable = num;
    }
}
