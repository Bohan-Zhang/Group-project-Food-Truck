
import javax.swing.ImageIcon;

public class Food {
    private final String name;
    private final double price;
    private final int calories;
    private final String description;
    private int inCart;
    private final int maxAvail;
    private int numAvailable;
    private final ImageIcon Image;

    public Food(String n, double p, int c, String d, int a, ImageIcon img) {
        name = n;
        price = p;
        calories = c;
        description = d;
        maxAvail = a;
        numAvailable = a;
        inCart = 0;
        Image = img;
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
    public ImageIcon getImage(){
        return Image;
    }
    public int getInCart(){
        return inCart;
    }

    public void addToCart(){
        if (inCart < maxAvail && numAvailable > 0){
            inCart++;
            numAvailable--;
        }
    }
    public void removeFromCart(){
        if (inCart > 0 && numAvailable < maxAvail){
            inCart--;
            numAvailable++;
        }
    }

    public void setNumAvailable(int num) {
        numAvailable = num;
    }

    

    
}
