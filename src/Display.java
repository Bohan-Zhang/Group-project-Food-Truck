import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.*;

@SuppressWarnings("LeakingThisInConstructor")
public class Display extends JFrame implements KeyListener, ActionListener {
    //allows access to screen's dimension, creates screen width and height vars as doubles
    private final Toolkit toolkit = Toolkit.getDefaultToolkit();
    private final Dimension screenSize = toolkit.getScreenSize();
    public final double screenWidth = screenSize.getWidth();
    public final double screenHeight = screenSize.getHeight();

    //menus
    private final Menu entreesMenu;
    private final Menu mainsMenu;
    private final Menu drinksMenu;
    private final Menu dessertsMenu;

    //Static Vars
    private static boolean nameSubmitted = false;
    private static String name;

    //Vars
    public double cartCost = 0.0;
    public ArrayList<Food> cart = new ArrayList<>();
    private String cartText;
    private String cartPrices;
    private int captchaCounter = 0;

    //Color or gif
    public final Color pastelPink = new Color(255, 200, 240);
    private final ImageIcon captchaComplete = new ImageIcon((Objects.requireNonNull(getClass().getResource("img/captchacomplete.gif"))));

    //creates components
    private final JLayeredPane programLayer;
    public final JLayeredPane phoneLayer;
    private final JLabel phone;
    private final JLabel restaurantName;
    private final JTextField namer;
    private final JLabel greetings;
    public final JLabel moneyLabel;
    private final JButton checkout;
    private final JButton back;
    private final JButton cartButton;
    private final JLabel cartNamesLabel;
    private final JLabel cartPricesLabel;
    private final JLabel captcha;
    private final JButton captchaButton;
    private final JLabel thanks;
    private final JButton again;
    private final JButton exit;

    //creates menu components
    private final JLabel entreesLabel;
    private final JButton entreesButton;
    private final JLabel mainsLabel;
    private final JButton mainsButton;
    private final JLabel drinksLabel;
    private final JButton drinksButton;
    private final JLabel dessertsLabel;
    private final JButton dessertsButton;

    public Display() {
        //frame setup
        this.setTitle("Babe's Château de Fast Food");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(0, 0, (int)screenWidth/3, (int) screenHeight);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(pastelPink);
        this.setUndecorated(false);
        this.addKeyListener(this);
        this.setVisible(true);

        //fullscreen checker setup
        //Timer fullscreenTimer = new Timer(8000, (ActionEvent a) -> {
            
        //});
        //fullscreenTimer.start();

        //layer setup
        programLayer = new JLayeredPane();
        programLayer.setBounds(0, 0, (int)screenWidth/3, (int) screenHeight);
        this.add(programLayer);

        //phone setup; option buttons will be added directly to the phone.
        phone = new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("img/phone.png"))));
        phone.setBounds(0, 0, (int) screenWidth/3, (int) screenHeight);
        programLayer.add(phone, JLayeredPane.PALETTE_LAYER);
        //phone layer setup
        phoneLayer = new JLayeredPane();
        phoneLayer.setBounds(0, 0, (int)screenWidth/3, (int) screenHeight);
        phone.add(phoneLayer);
        //name setup
        restaurantName = new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("img/name.png"))));
        restaurantName.setBounds((int)screenWidth/3/2-144,(int) screenHeight/2-300, 287, 115);
        phoneLayer.add(restaurantName, JLayeredPane.POPUP_LAYER);


        //namer setup
        namer = new JTextField("Who might you be?");
        namer.setBounds((int)screenWidth/3/2-150,(int) screenHeight/2-25,300,50);
        namer.setBackground(pastelPink);
        namer.addFocusListener(new FocusAdapter() {
            //runs when the user clicks on the field
            @Override
            public void focusGained(FocusEvent e) {
                if (namer.getText().equals("Who might you be?") || namer.getText().equals("Please verify your name to continue")) {
                    namer.setText("");
                }
            }
            //runs when the user clicks on something other than the field
            @Override
            public void focusLost(FocusEvent e) {
                if (namer.getText().isEmpty()) {
                    namer.setText("Please verify your name to continue");
                }
            }
        });
        namer.addKeyListener(this);
        phoneLayer.add(namer, JLayeredPane.POPUP_LAYER);

        //greetings text setup
        greetings = new JLabel("", SwingConstants.CENTER);
        greetings.setBounds((int)screenWidth/3/2-175, (int)screenHeight/2-150, 350, 25);
        greetings.setVisible(false);
        phoneLayer.add(greetings, JLayeredPane.DRAG_LAYER);

        //cart setup
        cartButton = new JButton("View orders");
        cartButton.setBounds((int) screenWidth/3/2+25, (int) screenHeight/3-180, 125, 25);
        cartButton.setBackground(pastelPink);
        cartButton.addActionListener(this);
        cartButton.setVisible(false);
        phoneLayer.add(cartButton, JLayeredPane.POPUP_LAYER);
        cartNamesLabel = new JLabel();
        cartNamesLabel.setBounds((int)screenWidth/3/2-150, (int)screenHeight/2-160, 350, 500);
        cartNamesLabel.setVisible(false);
        cartNamesLabel.setVerticalAlignment(SwingConstants.TOP);
        phoneLayer.add(cartNamesLabel, JLayeredPane.MODAL_LAYER);
        cartPricesLabel = new JLabel();
        cartPricesLabel.setBounds((int)screenWidth/3/2+100, (int)screenHeight/2-160, 50, 500);
        cartPricesLabel.setVisible(false);
        cartPricesLabel.setVerticalAlignment(SwingConstants.TOP);
        cartPricesLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        phoneLayer.add(cartPricesLabel, JLayeredPane.MODAL_LAYER);

        //money setup
        moneyLabel = new JLabel("<html><body>Cart: $0.00<html>");
        moneyLabel.setBounds((int) screenWidth/3/2-70, (int) screenHeight/3-180, 100, 25);
        moneyLabel.setVisible(false);
        phoneLayer.add(moneyLabel, JLayeredPane.DRAG_LAYER);

        //checkout button setup
        checkout = new JButton("Come 'n get it!");
        checkout.setBounds((int) screenWidth/3/2-75, (int) screenHeight/2+275, 150, 25);
        checkout.setBackground(pastelPink);
        checkout.addActionListener(this);
        checkout.setVisible(false);
        phoneLayer.add(checkout, JLayeredPane.POPUP_LAYER);

        //back button setup
        back = new JButton("Back");
        back.setBounds((int) screenWidth/3/2-150, (int) screenHeight/3-180, 75, 25);
        back.setBackground(pastelPink);
        back.addActionListener(this);
        back.setVisible(false);
        phoneLayer.add(back, JLayeredPane.POPUP_LAYER);

        //captcha setup for later
        captcha = new JLabel(new ImageIcon((Objects.requireNonNull(getClass().getResource("img/captcha.png")))));
        captcha.setBounds((int) screenWidth/2/3-125, (int) screenHeight/2-33, 250, 66);
        captcha.setVisible(false);
        phoneLayer.add(captcha, JLayeredPane.DRAG_LAYER);
        captchaButton = new JButton();
        captchaButton.setBackground(new Color(252,252,252));
        captchaButton.setBounds(15, 23, 21, 21);
        captchaButton.addActionListener(this);
        captcha.add(captchaButton);

        //thanks, again, and exit setup
        thanks = new JLabel("<html><body>Thank you for ordering, please come pick up your food immediately<html>", SwingConstants.CENTER);
        thanks.setBounds((int) screenWidth/2/3-150, (int) screenHeight/2-25,300, 50);
        thanks.setVisible(false);
        phoneLayer.add(thanks, JLayeredPane.DRAG_LAYER);

        again = new JButton("Order Again");
        again.setBounds((int) screenWidth/2/3-175, (int) screenHeight/2+200, 150, 25);
        again.setBackground(pastelPink);
        again.addActionListener(this);
        again.setVisible(false);
        phoneLayer.add(again, JLayeredPane.POPUP_LAYER);

        exit = new JButton("Exit App");
        exit.setBounds((int) screenWidth/2/3+15, (int) screenHeight/2+200, 150, 25);
        exit.setBackground(pastelPink);
        exit.addActionListener(this);
        exit.setVisible(false);
        phoneLayer.add(exit, JLayeredPane.POPUP_LAYER);

        //menu select setup
        //entrees label and button setup
        entreesLabel = new JLabel("Entrées", SwingConstants.CENTER);
        entreesButton = new JButton();
        this.optionSetup(entreesLabel, entreesButton, -150, -100, new ImageIcon((Objects.requireNonNull(getClass().getResource("img/GeneralEntrees.png")))));
        //mains label and button setup
        mainsLabel = new JLabel("Mains", SwingConstants.CENTER);
        mainsButton = new JButton();
        this.optionSetup(mainsLabel, mainsButton, 15, -100, new ImageIcon((Objects.requireNonNull(getClass().getResource("img/Mains Food.png")))));
        //drinks label and button setup
        drinksLabel = new JLabel("Drinks", SwingConstants.CENTER);
        drinksButton = new JButton();
        this.optionSetup(drinksLabel, drinksButton, -150, 100, new ImageIcon((Objects.requireNonNull(getClass().getResource("img/GeneralDrink.png")))));
        //desserts label and button setup
        dessertsLabel = new JLabel("Desserts", SwingConstants.CENTER);
        dessertsButton = new JButton();
        this.optionSetup(dessertsLabel, dessertsButton, 15, 100, new ImageIcon((Objects.requireNonNull(getClass().getResource("img/name.png")))));

        EntreesFood entrees = new EntreesFood();
        entreesMenu = new Menu(entrees.chips, entrees.calamari, entrees.scallops, entrees.macNCheese, entrees.fries, entrees.frys, entrees.chickenNuggets, entrees.shrimp, this);

        MainsFood mains = new MainsFood();
        mainsMenu = new Menu(mains.cheeseburger, mains.hotdog, mains.pasta, mains.grilledCheese, mains.turkeySandwich, mains.tacos, mains.pizza, mains.hamburger, this);

        Drink drinks = new Drink();
        drinksMenu = new Menu(drinks.redGlass, drinks.redBottle, drinks.whiteGlass, drinks.whiteBottle, drinks.citrusSplash, drinks.berryBreeze, drinks.pinaColada, drinks.bananaShake, this);
        
        DessertsFoods desserts = new DessertsFoods(); 
        dessertsMenu = new Menu(desserts.vanillaIceCream, desserts.chocolateIceCream, desserts.strawberryIceCream, desserts.brownie, desserts.chocolateChipCookie, desserts.butterCookie, desserts.applePie, desserts.glazedDonut, this);
        
        this.update();

        if (nameSubmitted){
            namer.setVisible(false);
            moneyLabel.setVisible(true);
            cartButton.setVisible(true);
            mainMenuVisibilities(true);
        }

        this.addWindowStateListener((WindowEvent e) -> {
            if ((e.getNewState() & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH) {
                phone.setLocation((int) screenWidth/3, 0);
            } else if ((e.getOldState() & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH) {
                phone.setLocation(0, 0);
            }
        });
    }

    public final void optionSetup(JLabel label, JButton button, int xOffset, int yOffset, ImageIcon img){
        label.setBounds((int) screenWidth/3/2+xOffset, (int) screenHeight/2+yOffset+100, 125,50);
        label.setOpaque(true);
        label.setBackground(pastelPink);
        label.setVisible(false);
        phoneLayer.add(label, JLayeredPane.POPUP_LAYER);
        button.setBounds((int) screenWidth/3/2+xOffset, (int) screenHeight/2+yOffset, 125, 100);
        button.setBackground(pastelPink); //remove once image set (or not if invisible bg on image)
        button.setIcon(img);
        button.addActionListener(this);
        button.setVisible(false);
        phoneLayer.add(button, JLayeredPane.MODAL_LAYER);
    }


    //keyboard actions
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER && !namer.getText().isEmpty() && (!namer.getText().equals("Who might you be?") || !namer.getText().equalsIgnoreCase("Please verify your name to continue")) && (!nameSubmitted || namer.getText().equals(name))){
            if (!nameSubmitted){
                namer.setVisible(false);
                name = namer.getText();
                moneyLabel.setVisible(true);
                cartButton.setVisible(true);
                this.mainMenuVisibilities(true);
                nameSubmitted = true;
            }
            else{
                namer.setVisible(false);
                cartNamesLabel.setVisible(false);
                cartPricesLabel.setVisible(false);
                back.setVisible(false);
                moneyLabel.setVisible(false);
                captcha.setVisible(true);
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {}

    //button actions
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == entreesButton){
            mainMenuVisibilities(false);
            entreesMenu.setMenuVisibility(true);
        }
        else if(e.getSource() == mainsButton){
            this.mainMenuVisibilities(false);
            mainsMenu.setMenuVisibility(true);
        }
        else if(e.getSource() == drinksButton){
            this.mainMenuVisibilities(false);
            drinksMenu.setMenuVisibility(true);
        }
        else if(e.getSource() == dessertsButton){
            this.mainMenuVisibilities(false);
            dessertsMenu.setMenuVisibility(true);
        }
        else if(e.getSource() == checkout) {
            if(cartButton.isVisible()) {
                
            }
            cartText = "<html><body>"; 
            cartPrices = "<html><body>";
            for (int i = 0; i<cart.size(); i++){
                cartText += cart.get(i).getName() + "<br><br>";
                cartPrices += "$" + addZeroes(cart.get(i).getPrice()) + "<br><br>";
            }
            cartText += "TOTAL<html>";
            cartPrices += "$" + addZeroes(cartCost) + "<html>";

            if(cart.isEmpty()){
                cartText = "Your cart is empty";
            }
    
            cartNamesLabel.setText(cartText);
            cartPricesLabel.setText(cartPrices);
            
            cartButton.setVisible(false);
            cartNamesLabel.setVisible(true);
            cartPricesLabel.setVisible(true);
            this.mainMenuVisibilities(false);
            entreesMenu.setMenuVisibility(false);
            mainsMenu.setMenuVisibility(false);
            drinksMenu.setMenuVisibility(false);
            dessertsMenu.setMenuVisibility(false);

            if(!cart.isEmpty()){
                namer.setLocation((int) screenWidth/3/2-150, (int) screenHeight/2+275);
                namer.setText("Please verify your name to continue");
                namer.setVisible(true);
            }
        } 
        else if (e.getSource() == cartButton) {
            cartText = "<html><body>"; 
            cartPrices = "<html><body>";
            for (int i = 0; i<cart.size(); i++){
                cartText += cart.get(i).getName() + "<br><br>";
                cartPrices += "$" + addZeroes(cart.get(i).getPrice()) + "<br><br>";
            }
            cartText += "TOTAL<html>";
            cartPrices += "$" + addZeroes(cartCost) + "<html>";

            if(cart.isEmpty()){
                cartText = "Your cart is empty";
            }
    
            cartNamesLabel.setText(cartText);
            cartPricesLabel.setText(cartPrices);
            
            cartButton.setVisible(false);
            cartNamesLabel.setVisible(true);
            cartPricesLabel.setVisible(true);
            this.mainMenuVisibilities(false);
            entreesMenu.setMenuVisibility(false);
            mainsMenu.setMenuVisibility(false);
            drinksMenu.setMenuVisibility(false);
            dessertsMenu.setMenuVisibility(false);

            checkout.setVisible(true);
        }
        else if(e.getSource() == back){
            this.mainMenuVisibilities(true);
            namer.setVisible(false);
            cartButton.setVisible(true);
            cartNamesLabel.setVisible(false);
            cartPricesLabel.setVisible(false);
            entreesMenu.setMenuVisibility(false);
            mainsMenu.setMenuVisibility(false);
            drinksMenu.setMenuVisibility(false);
            dessertsMenu.setMenuVisibility(false);
        }
        else if(e.getSource() == captchaButton){
            int rand = (int) (Math.random() * (100-captchaCounter) + captchaCounter);
            if (rand < 90|| captchaCounter == 0){
                captchaCounter += 25;
                captcha.setLocation((int) screenWidth/2/3+((int) (Math.random() * (-80 + 180) - 180)), (int) screenHeight/2+((int) (Math.random() * (265 + 180) -180)));
                this.update();
            }
            else {
                captchaComplete.getImage().flush();
                captchaButton.setVisible(false);
                captcha.setIcon(captchaComplete);
                Timer gifTimer = new Timer(8000, (ActionEvent a) -> {
                    captcha.setVisible(false);
                    thanks.setVisible(true);
                    again.setVisible(true);
                    exit.setVisible(true);
                });
                gifTimer.start();
            }
        }
        else if (e.getSource() == again){
            Main.restart();
            dispose();
        }
        else if (e.getSource() == exit){
            dispose();
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

    public final void mainMenuVisibilities(boolean visibility){
        greetings.setVisible(visibility);
        greetings.setText("Greetings and salutations, " + name + "!");
        checkout.setVisible(visibility);
        back.setVisible(!visibility);
        entreesLabel.setVisible(visibility);
        entreesButton.setVisible(visibility);
        mainsLabel.setVisible(visibility);
        mainsButton.setVisible(visibility);
        drinksLabel.setVisible(visibility);
        drinksButton.setVisible(visibility);
        dessertsLabel.setVisible(visibility);
        dessertsButton.setVisible(visibility);
    }

    public final void update(){
        this.revalidate();
        this.repaint();
    }
}