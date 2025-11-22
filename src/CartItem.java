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
        add.setBounds(400, yPos, 50, 30);
        add.setBounds((int) screenWidth/3/2-50, (int) screenHeight/2 - yPos, 63, 25);
        add.setText("+");
        add.addActionListener(this);
        screen.add(add);

        subtract.setBounds(460, yPos, 50, 30);
        subtract.setText("-");
        subtract.addActionListener(this);
        screen.add(subtract);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            food.addToCart();
        } else if (e.getSource() == subtract) {
            food.removeFromCart();
        }
    }
}
