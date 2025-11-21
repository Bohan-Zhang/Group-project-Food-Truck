import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;

public class CartItem extends JFrame implements ActionListener{

    public static ArrayList<CartItem> cartItems = new ArrayList<>();
    private Food food;
    private JButton add = new JButton();
    private JButton subtract = new JButton();
    private Display screen;
    public int yPos;

    public CartItem(Food f, Display s, int y) {
        food = f;
        screen = s;
        yPos = y;
        cartItems.add(this);
        setupButtons();
    }

    public void setCartVisibility(boolean visibility){
        add.setVisible(visibility);
        subtract.setVisible(visibility);
    }

    public void setupButtons() {

    }

    @Override

    public void actionPerformed(ActionEvent e) {

    }
}
