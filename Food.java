public class Food {
    private String name;
    private double price;
    private int calories;
    private String description;
    private int numAvailable;

    public Food(String n, double p, String c, String d, int a) {
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
    public String getCalories() {
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
