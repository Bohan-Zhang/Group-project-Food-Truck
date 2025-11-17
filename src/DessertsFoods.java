


public class DessertsFoods {

    public Food vanillaIceCream;
    public Food chocolateIceCream;
    public Food strawberryIceCream;
    public Food brownie;
    public Food chocolateChipCookie;
    public Food butterCookie;
    public Food applePie;
    public Food glazedDonut;
    
    // Will display the menu.
    public DessertsFoods() {
        vanillaIceCream = new Food("Vanilla Ice Cream", 3.50, 250, "Soft-served vanilla ice cream.",5);
        chocolateIceCream = new Food("Chocolate Ice Cream", 3.50, 250, "Soft-served chocolate ice cream.",5);
        strawberryIceCream = new Food("Strawberry Ice Cream", 3.50, 250, "A scoop of mint chocolate ice cream.",5);
        brownie = new Food("Brownie", 2.75, 250, "Two rich chocolate brownies.",5);
        chocolateChipCookie = new Food("Chocolate Chip Cookie", 1.00, 200, "A classic chocolate chip cookie.",5);
        butterCookie = new Food("Butter Cookie", 1.00, 200, "A classic butter cookie.",5);
        applePie = new Food("Baked Apple Pie", 2.00, 250, "A warm turnover handpie filled with spiced apples.",5);
        glazedDonut = new Food("Glazed Donut", 1.50, 250, "A glazed donut that melts in your mouth.",5);
    }

    public void sellDessert(Food dessert) {
        //System.out.println("You have purchased: " + dessert.getName() + " for $" + dessert.getPrice());
        dessert.setNumAvailable(dessert.getNumAvailable() - 1);
    }

    
    public String toString(Food dessert) {
        return ("A " + dessert.getName() + " costs $" + dessert.getPrice() + ". " + dessert.getDescription() + " Calories: " + dessert.getCalories() + ". Available: " + dessert.getNumAvailable());
    }

    


    
}