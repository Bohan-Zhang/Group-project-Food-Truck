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

    public static ArrayList<CartItem> cartItems = new ArrayList<>();
    public static int yPos = 0;
    public static boolean cartVisible = false;
    private final Food food;
    
    private JLabel itemLabel = new JLabel();
    private JButton addButton = new JButton();
    private JButton subtractButton = new JButton();
    private Display screen;
    

    public CartItem(Food f, Display s) {
        food = f;
        screen = s;
        cartItems.add(this);

    }

    public static void setCartVisibility(boolean visibility){
        for (CartItem item : cartItems) {
            item.itemLabel.setVisible(visibility);
            item.addButton.setVisible(visibility);
            item.subtractButton.setVisible(visibility);
        }
    }

    private String addZeroes(double number) {
        String numString = Double.toString(number);
        if (numString.indexOf(".") == numString.length() - 2){ // If the decimal point is the second last character 
            numString += "0";
        } else if ((numString.length() - numString.indexOf(".") + 1) >= 4){ // Removing trailing zeroes for some reason
            numString = numString.substring(0, numString.indexOf(".") + 3);
            
        }
        return numString;
    }

    public void addToScreen() {

        updatePosition(yPos);

        itemLabel.setText("<html>" + food.getName() + " quantity: " + food.getInCart() + ", Spent $" + addZeroes(food.getInCart() * food.getPrice()) + "<html>");
        screen.phoneLayer.add(itemLabel, JLayeredPane.POPUP_LAYER);
        
        addButton.setText("+");
        addButton.addActionListener(this);
        screen.phoneLayer.add(addButton, JLayeredPane.POPUP_LAYER);

        subtractButton.setText("-");
        subtractButton.addActionListener(this);
        screen.phoneLayer.add(subtractButton, JLayeredPane.POPUP_LAYER);

        //System.out.println("itemlabel visible?" + itemLabel.isVisible());
    }

    public void updatePosition(int y) {
        yPos = y;
        itemLabel.setBounds((int) screenWidth/3/2-130, yPos + cartItems.indexOf(this) * 40 + 250, 250, 25);
        addButton.setBounds((int) screenWidth/3/2+47, yPos + cartItems.indexOf(this) * 40 + 250, 63, 25);
        subtractButton.setBounds((int) screenWidth/3/2+110, yPos + cartItems.indexOf(this) * 40 + 250, 63, 25);
    }

    public static void updateAllPositions(int y) {
        yPos = y;
        for (CartItem item : cartItems) {
            item.updatePosition(y);
        }
    }

    public void removeFromList() {
        screen.phoneLayer.remove(itemLabel);
        screen.phoneLayer.remove(addButton);
        screen.phoneLayer.remove(subtractButton);
        cartItems.remove(this);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        screen.update();
        if (e.getSource() == addButton) {
            food.addToCart();
            
        } else if (e.getSource() == subtractButton) {
            food.removeFromCart();
        }
    }
}
