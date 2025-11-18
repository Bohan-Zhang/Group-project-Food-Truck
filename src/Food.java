public class Food {
    private String name;
    private double price;
    private int calories;
    private String description;
    private int inCart;
    private int totalAvailable;
    private int numAvailable;

    public Food(String n, double p, int c, String d, int a) {
        name = n;
        price = p;
        calories = c;
        description = d;
        totalAvailable = a;
        numAvailable = a;
        inCart = 0;
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
    public int getInCart(){
        return inCart;
    }

    public void addToCart(){
        if (inCart < totalAvailable && numAvailable > 0){
            inCart++;
            numAvailable--;
        }
    }
    public void removeFromCart(){
        if (inCart > 0 && numAvailable < totalAvailable){
            inCart--;
            numAvailable++;
        }
    }

    public void setNumAvailable(int num) {
        numAvailable = num;
    }

    

    
}
