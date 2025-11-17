public class Drink {
    private String name;
    private double price;
    private int calories;
    private String description;
    private int numAvailable;
    public Food redGlass;
    public Food redBottle;
    public Food whiteGlass;
    public Food whiteBottle;
    public Food citrusSplash;
    public Food berryBreeze;
    public Food pinaColada;
    public Food tequila;

    public Drink(){
    redGlass = new Food("Red Wineglass", 13.50, 133, "A Glass of Merlot", 20);
    redBottle = new Food("Red Winebottle", 29.99, 295,"A Full Bottle of Merlot for you to take home", 10);
    whiteGlass = new Food("White Wineglass", 9.99, 120, "A Glass of Chardonnay", 20);
    whiteBottle = new Food("White Winebottle", 22.18, 266, "A Full Bottle of Chardonnay for you to take home", 10);
    citrusSplash = new Food("Citrus Splash", 9.50, 50, "A sweet, refreshing drink made from mixed citrus juices like orange, tangerine, grapefruit, and lime.", 20);
    berryBreeze = new Food("Berry Breeze", 2.50, 70, "A fruity, refreshing drink made from a blend of mixed berries like strawberry, blueberry, and raspberry.", 20);
    pinaColada = new Food("Piña Colada", 3.00, 120, "A sweet, creamy drink made with pineapple and coconut.", 20);
    tequila = new Food("Tequila", 7.50, 330, "A strong, clear spirit made from the blue agave plant in Mexico.", 10);
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
