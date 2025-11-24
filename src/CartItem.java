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
    private final Food food;
    private JLabel itemLabel = new JLabel();
    private JButton addButton = new JButton();
    private JButton subtractButton = new JButton();
    private Display screen;
    public int yPos;

    public CartItem(Food f, Display s, int y) {
        food = f;
        screen = s;
        yPos = y;
        cartItems.add(this);
        setupGraphics();
        setCartVisibility(false);
    }

    public void setCartVisibility(boolean visibility){
        itemLabel.setVisible(visibility);
        addButton.setVisible(visibility);
        subtractButton.setVisible(visibility);
    }

    public void setupGraphics() {

        itemLabel.setBounds((int) screenWidth/3/2-150, (int) screenHeight/2 - yPos , 63, 25);
        itemLabel.setText("<html>" + food.getName() + " quantity: " + food.getInCart() + ", Spent $" + food.getInCart() * food.getPrice() + "<html>");
        screen.phoneLayer.add(itemLabel, JLayeredPane.POPUP_LAYER);
        
        addButton.setBounds((int) screenWidth/3/2-80, (int) screenHeight/2 - yPos , 63, 25);
        addButton.setText("+");
        addButton.addActionListener(this);
        screen.phoneLayer.add(addButton, JLayeredPane.POPUP_LAYER);

        addButton.setBounds((int) screenWidth/3/2-50, (int) screenHeight/2 - yPos , 63, 25);
        subtractButton.setText("-");
        subtractButton.addActionListener(this);
        screen.phoneLayer.add(subtractButton, JLayeredPane.POPUP_LAYER);


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
        if (e.getSource() == addButton) {
            food.addToCart();
            
        } else if (e.getSource() == subtractButton) {
            food.removeFromCart();
        }
    }
}
