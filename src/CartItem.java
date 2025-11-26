import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;

public class CartItem extends JFrame implements ActionListener{

    private final Toolkit toolkit = Toolkit.getDefaultToolkit();
    private final Dimension screenSize = toolkit.getScreenSize();
    final double screenWidth = screenSize.getWidth();
    final double screenHeight = screenSize.getHeight();
    private static int pageNum = 1;

    public static ArrayList<CartItem> allInCart = new ArrayList<>();
    public static ArrayList<CartItem> displayedCart = new ArrayList<>();
    public static boolean cartVisible = false;
    private final Food food;
    
    private JLabel itemLabel = new JLabel();
    private JButton addButton = new JButton();
    private JButton subtractButton = new JButton();
    private static Display screen;

    public CartItem(Food f, Display s) {
        food = f;
        screen = s;
        
    }

    public static void setCartVisibility(boolean visibility){
        for (CartItem item : allInCart) {
            item.itemLabel.setVisible(visibility);
            item.addButton.setVisible(visibility);
            item.subtractButton.setVisible(visibility);
        }
    }

    public void addToScreen() {

        updateText();
        System.out.println("CartItem 43: Food: " + food.getName() + " Index:" + displayedCart.indexOf(this) + " allInCart: " + displayedCart);
        
        itemLabel.setBounds((int) screenWidth/3/2-150, displayedCart.indexOf(this) * 40 + 250, 300, 25);
        screen.phoneLayer.add(itemLabel, JLayeredPane.POPUP_LAYER);
        
        addButton.setBounds((int) screenWidth/3/2-150, displayedCart.indexOf(this) * 40 + 270, 63, 25);
        addButton.addActionListener(this);
        screen.phoneLayer.add(addButton, JLayeredPane.POPUP_LAYER);

        subtractButton.setBounds((int) screenWidth/3/2-87, displayedCart.indexOf(this) * 40 + 270, 63, 25);
        subtractButton.addActionListener(this);
        screen.phoneLayer.add(subtractButton, JLayeredPane.POPUP_LAYER);

        if (!allInCart.contains(this)) {
            System.out.println("CartItem57:this" + this);
            allInCart.add(this);
        }
        //System.out.println("itemlabel visible?" + itemLabel.isVisible());
    }

    public void removeFromScreen() {
        screen.phoneLayer.remove(itemLabel);
        screen.phoneLayer.remove(addButton);
        screen.phoneLayer.remove(subtractButton);
        allInCart.remove(this);
        displayedCart.remove(this);
        System.out.println("CartItem69:Removed " + this + " from screen");
    }

    public static void updateDisplayedCart() {


        displayedCart.clear();
        
        int startIndex = (pageNum - 1) * 11;
        int endIndex = Math.min(startIndex + 11, screen.cart.size());
        System.out.println("CartItem78:startIndex: " + startIndex + " endIndex: " + endIndex);
        for (int i = startIndex; i < endIndex; i++) {
            
            if (!displayedCart.contains(allInCart.get(i))) {
                displayedCart.add(allInCart.get(i));
            }
            
        }
    }

    public void updateText() {
        itemLabel.setText("<html>" + food.getName() + " quantity: " + food.getInCart() + ", Spent $" + Main.addZeroes(food.getInCart() * food.getPrice()) + "<html>");
        addButton.setText("+");
        subtractButton.setText("-");
    }

    
    public Food getFood() {
        return food;
    }

    public JLabel getItemLabel() {
        return itemLabel;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getSubtractButton() {
        return subtractButton;
    }

    public void nextPage() {
        if (pageNum * 11 >= allInCart.size()) {
            return;
        }
        pageNum ++;

    }

    public void previousPage() {
        if (pageNum == 1) {
            return;
        }
        pageNum --;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        screen.update();
        if (e.getSource() == addButton) {

            if (food.getInCart() == 0) { // If this is the first of this item added to cart, create a new CartItem
                screen.cart.add(food);
            }
            food.addToCart();
            
            screen.updateCheckout();
            updateText();


            System.out.println("CartItem142:Adding to cart through cart: " + food.getName());
            
            
        } else if (e.getSource() == subtractButton) {

            if (food.getInCart() == 1) { // If this was the last of this item in the cart, remove the CartItem
                screen.cart.remove(food);
            }
            food.removeFromCart();  

            screen.updateCheckout();
            updateText();


            System.out.println("CartItem156:Removing from cart through cart: " + food.getName());
        }
    }

    @Override
    public String toString() {
        return food.getName() + " x" + food.getInCart();
    }

}
