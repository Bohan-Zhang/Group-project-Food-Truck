


public class DessertsFoods {

    public Food vanillaIceCream = new Food("Vanilla Ice Cream", 3.50, 250, "Soft-served vanilla ice cream.",5);
    public Food chocolateIceCream = new Food("Chocolate Ice Cream", 3.50, 250, "Soft-served chocolate ice cream.",5);
    public Food strawberryIceCream = new Food("Strawberry Ice Cream", 3.50, 250, "A scoop of mint chocolate ice cream.",5);
    public Food brownie = new Food("Brownie", 2.75, 250, "Two rich chocolate brownies.",5);
    public Food chocolateChipCookie = new Food("Chocolate Chip Cookie", 1.00, 200, "A classic chocolate chip cookie.",5);
    public Food butterCookie = new Food("Butter Cookie", 1.00, 200, "A classic butter cookie.",5);
    public Food applePie = new Food("Baked Apple Pie", 2.00, 250, "A warm turnover handpie filled with spiced apples.",5);
    
    // Will display the menu.
    public DessertsFoods() {
        
    }

    public void sellDessert(Food dessert) {
        //System.out.println("You have purchased: " + dessert.getName() + " for $" + dessert.getPrice());
        dessert.setNumAvailable(dessert.getNumAvailable() - 1);
    }

    
    public String toString(Food dessert) {
        return ("A " + dessert.getName() + " costs $" + dessert.getPrice() + ". " + dessert.getDescription() + " Calories: " + dessert.getCalories() + ". Available: " + dessert.getNumAvailable());
    }

    


    
}