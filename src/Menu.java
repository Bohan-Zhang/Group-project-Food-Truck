import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Menu implements ActionListener {
    private final Toolkit toolkit = Toolkit.getDefaultToolkit();
    private final Dimension screenSize = toolkit.getScreenSize();
    final double screenWidth = screenSize.getWidth();
    final double screenHeight = screenSize.getHeight();

    Display screen;
    JLabel pictureBG = new JLabel();
    JLabel picture = new JLabel();
    JLabel cost = new JLabel();
    JLabel calories = new JLabel();
    JLabel inStock = new JLabel();
    JLabel inCart = new JLabel();
    JLabel description = new JLabel("Click an item to see its description here!", SwingConstants.CENTER);
    int currentDetails;

    JButton item1Name;
    JButton add1 = new JButton();
    JButton subtract1 = new JButton();
    JButton item2Name;
    JButton add2 = new JButton();
    JButton subtract2 = new JButton();
    JButton item3Name;
    JButton add3 = new JButton();
    JButton subtract3 = new JButton();
    JButton item4Name;
    JButton add4 = new JButton();
    JButton subtract4 = new JButton();
    JButton item5Name;
    JButton add5 = new JButton();
    JButton subtract5 = new JButton();
    JButton item6Name;
    JButton add6 = new JButton();
    JButton subtract6 = new JButton();
    JButton item7Name;
    JButton add7 = new JButton();
    JButton subtract7 = new JButton();
    JButton item8Name;
    JButton add8 = new JButton();
    JButton subtract8 = new JButton();

    Food item1;
    Food item2;
    Food item3;
    Food item4;
    Food item5;
    Food item6;
    Food item7;
    Food item8;


    public Menu(Food item1, Food item2, Food item3, Food item4, Food item5, Food item6, Food item7, Food item8, Display screen){
        this.screen = screen;
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
        this.item4 = item4;
        this.item5 = item5;
        this.item6 = item6;
        this.item7 = item7;
        this.item8 = item8;

        pictureBG.setBounds((int) screenWidth/3/2-150, (int) screenHeight/2+250, 100, 100);
        screen.phoneLayer.add(pictureBG, JLayeredPane.PALETTE_LAYER);
        pictureBG.setVisible(false);
        createDetail(picture, -150, 250, 100, 100);
        createDetail(description, -150, 200, 300, 50);
        createDetail(cost, -40, 250, 130, 25);
        createDetail(calories, -40, 275, 130, 25);
        createDetail(inStock, -40, 300, 130, 25);
        createDetail(inCart, -40, 325, 130, 25);
        

        item1Name = new JButton("<html><body>"+item1.getName()+"<html>");
        item2Name = new JButton("<html><body>"+item2.getName()+"<html>");
        item3Name = new JButton("<html><body>"+item3.getName()+"<html>");
        item4Name = new JButton("<html><body>"+item4.getName()+"<html>");
        item5Name = new JButton("<html><body>"+item5.getName()+"<html>");
        item6Name = new JButton("<html><body>"+item6.getName()+"<html>");
        item7Name = new JButton("<html><body>"+item7.getName()+"<html>");
        item8Name = new JButton("<html><body>"+item8.getName()+"<html>");

        createItemOption(item1Name, add1, subtract1, -150, -145);
        createItemOption(item2Name, add2, subtract2, 20, -145);
        createItemOption(item3Name, add3, subtract3, -150, -55);
        createItemOption(item4Name, add4, subtract4, 20,-55);
        createItemOption(item5Name, add5, subtract5, -150, 45);
        createItemOption(item6Name, add6, subtract6, 20, 45);
        createItemOption(item7Name, add7, subtract7, -150, 135);
        createItemOption(item8Name, add8, subtract8, 20, 135);
    }

    public final void createItemOption(JButton itemName, JButton add, JButton subtract, int xOffset, int yOffset){
        itemName.setBounds((int) screenWidth/3/2+xOffset, (int) screenHeight/2+yOffset, 125,50);
        itemName.setOpaque(true);
        itemName.setBackground(screen.pastelPink);
        itemName.addActionListener(this);
        itemName.setVisible(false);
        screen.phoneLayer.add(itemName, JLayeredPane.POPUP_LAYER);

        add.setText("+");
        add.setBounds((int) screenWidth/3/2+xOffset, (int) screenHeight/2+yOffset+50, 63, 25);
        add.setBackground(screen.pastelPink); //remove once image set (or not if invisible bg on image)
        add.addActionListener(this);
        add.setVisible(false);
        screen.phoneLayer.add(add, JLayeredPane.POPUP_LAYER);

        subtract.setText("-");
        subtract.setBounds((int) screenWidth/3/2+xOffset+62, (int) screenHeight/2+yOffset+50, 63, 25);
        subtract.setBackground(screen.pastelPink); //remove once image set (or not if invisible bg on image)
        subtract.addActionListener(this);
        subtract.setVisible(false);
        screen.phoneLayer.add(subtract, JLayeredPane.POPUP_LAYER);
    }

    public final void createDetail(JLabel detail, int xOffset, int yOffset, int width, int height){
        detail.setBounds((int) screenWidth/3/2+xOffset, (int) screenHeight/2+yOffset, width, height);
        screen.phoneLayer.add(detail, JLayeredPane.MODAL_LAYER);
        detail.setVisible(false);
    }

    public void setMenuVisibility(boolean visibility){
        pictureBG.setVisible(visibility);
        picture.setVisible(visibility);
        cost.setVisible(visibility);
        calories.setVisible(visibility);
        inStock.setVisible(visibility);
        inCart.setVisible(visibility);
        description.setVisible(visibility);

        item1Name.setVisible(visibility);
        add1.setVisible(visibility);
        subtract1.setVisible(visibility);
        item2Name.setVisible(visibility);
        add2.setVisible(visibility);
        subtract2.setVisible(visibility);
        item3Name.setVisible(visibility);
        add3.setVisible(visibility);
        subtract3.setVisible(visibility);
        item4Name.setVisible(visibility);
        add4.setVisible(visibility);
        subtract4.setVisible(visibility);
        item5Name.setVisible(visibility);
        add5.setVisible(visibility);
        subtract5.setVisible(visibility);
        item6Name.setVisible(visibility);
        add6.setVisible(visibility);
        subtract6.setVisible(visibility);
        item7Name.setVisible(visibility);
        add7.setVisible(visibility);
        subtract7.setVisible(visibility);
        item8Name.setVisible(visibility);
        add8.setVisible(visibility);
        subtract8.setVisible(visibility);
    }

    public void setDetails(Food item, int current){
        pictureBG.setIcon(new ImageIcon((getClass().getResource("img/FoodBG.png"))));
        picture.setIcon(item.getImage()); //change to food img
        cost.setText("$" + addZeroes(item.getPrice()));
        calories.setText(item.getCalories() + " calories");
        inStock.setText(item.getNumAvailable() + " in stock");
        inCart.setText(item.getInCart() + " in your cart");
        description.setText("<html><body>" + item.getDescription() + "<html>");
        currentDetails = current;
        screen.update();
    }

    public void changeCart(Object source, JButton add, JButton subtract, Food item, int current){
        if(source == add && item.getNumAvailable() > 0){
            item.addToCart();
            screen.cartCost += item.getPrice();
            if (item.getInCart() == 1) { // If this is the first of this item added to cart, create a new CartItem
                screen.cart.add(item);
            }
        }
        else if (source == subtract && item.getInCart() > 0 && screen.cartCost - item.getPrice() >= 0){
            item.removeFromCart();     
            screen.cartCost -= item.getPrice();
            
            if (item.getInCart() == 0) { // If this was the last of this item in the cart, remove the CartItem
                screen.cart.remove(item);
            }
            
        }

        screen.moneyLabel.setText("<html><body>Cart: $" + addZeroes(screen.cartCost)+ "<html>");
        if (currentDetails == current){
            setDetails(item, current);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == item1Name){
            setDetails(item1, 1);
        }
        else if(e.getSource() == add1 || e.getSource() == subtract1){
            changeCart(e.getSource(), add1, subtract1, item1, 1);
        }

        else if (e.getSource() == item2Name){
            setDetails(item2, 2);
        }
        else if(e.getSource() == add2 || e.getSource() == subtract2){
            changeCart(e.getSource(), add2, subtract2, item2, 2);
        }

        else if (e.getSource() == item3Name){
            setDetails(item3,3);
        }
        else if(e.getSource() == add3 || e.getSource() == subtract3){
            changeCart(e.getSource(), add3, subtract3, item3, 3);
        }
    
        else if (e.getSource() == item4Name){
            setDetails(item4,4);
        }
        else if(e.getSource() == add4 || e.getSource() == subtract4){
            changeCart(e.getSource(), add4, subtract4, item4, 4);
        }

        else if (e.getSource() == item5Name){
            setDetails(item5,5);
        }
        else if(e.getSource() == add5 || e.getSource() == subtract5){
            changeCart(e.getSource(), add5, subtract5, item5, 5);
        }
        
        else if (e.getSource() == item6Name){
            setDetails(item6,6);
        }
        else if(e.getSource() == add6 || e.getSource() == subtract6){
            changeCart(e.getSource(), add6, subtract6, item6, 6);
        }
       
        else if (e.getSource() == item7Name){
            setDetails(item7,7);
        }
        else if(e.getSource() == add7 || e.getSource() == subtract7){
            changeCart(e.getSource(), add7, subtract7, item7, 7);
        }

        else if (e.getSource() == item8Name){
            setDetails(item8,8);
        }
        else if(e.getSource() == add8 || e.getSource() == subtract8){
            changeCart(e.getSource(), add8, subtract8, item8, 8);
        }
    }
}
