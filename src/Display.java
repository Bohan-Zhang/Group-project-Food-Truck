import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.*;

public class Display extends JFrame implements KeyListener, ActionListener {
    //allows access to screen's dimension, creates screen width and height vars as doubles
    private final Toolkit toolkit = Toolkit.getDefaultToolkit();
    private final Dimension screenSize = toolkit.getScreenSize();
    final double screenWidth = screenSize.getWidth();
    final double screenHeight = screenSize.getHeight();

    //Vars
    boolean nameSubmitted = false;

    //COLOR
    Color pastelPink = new Color(255, 200, 240);

    //creates components
    JLayeredPane programLayer;
    JLayeredPane phoneLayer;
    JLabel phone;
    JLabel restaurantName;
    JTextField namer;
    JLabel greetings;
    JButton checkout;

    //creates menu components
    JLabel entreesLabel;
    JButton entreesButton;
    JLabel mainsLabel;
    JButton mainsButton;
    JLabel drinksLabel;
    JButton drinksButton;
    JLabel dessertsLabel;
    JButton dessertsButton;


    public Display() {
        //frame setup
        this.setTitle("Babe's Château de Fast Food");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(0, 0, (int)screenWidth/3, (int) screenHeight);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(pastelPink);
        this.addKeyListener(this);
        this.setVisible(true);

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
                if (namer.getText().equals("Who might you be?")) {
                    namer.setText("");
                }
            }
            //runs when the user clicks on something other than the field
            @Override
            public void focusLost(FocusEvent e) {
                if (namer.getText().isEmpty()) {
                    namer.setText("Who might you be?");
                }
            }
        });
        namer.addKeyListener(this);
        phoneLayer.add(namer, JLayeredPane.POPUP_LAYER);

        //greetings text setup
        greetings = new JLabel("", SwingConstants.CENTER);
        greetings.setBounds((int)screenWidth/3/2-175, (int)screenHeight/2-150, 350, 25);
        greetings.setVisible(false);
        phoneLayer.add(greetings);

        //checkout button setup
        checkout = new JButton("Come 'n get it!");
        checkout.setBounds((int) screenWidth/3/2-75, (int) screenHeight/2+275, 150, 25);
        checkout.setBackground(pastelPink);
        checkout.addActionListener(this);
        checkout.setVisible(false);
        phoneLayer.add(checkout, JLayeredPane.POPUP_LAYER);

        //menu select setup
        //entrees label and button setup
        entreesLabel = new JLabel("Entrees", SwingConstants.CENTER);
        entreesButton = new JButton();
        this.optionSetup(entreesLabel, entreesButton, -150, -100);
        //mains label and button setup
        mainsLabel = new JLabel("Mains", SwingConstants.CENTER);
        mainsButton = new JButton();
        this.optionSetup(mainsLabel, mainsButton, 15, -100);
        //drinks label and button setup
        drinksLabel = new JLabel("Drinks", SwingConstants.CENTER);
        drinksButton = new JButton();
        this.optionSetup(drinksLabel, drinksButton, -150, 100);
        //desserts label and button setup
        dessertsLabel = new JLabel("Desserts", SwingConstants.CENTER);
        dessertsButton = new JButton();
        this.optionSetup(dessertsLabel, dessertsButton, 15, 100);

        this.update();

        //checks if it is fullscreen or not, centers if it is fullscreen
        while (true) {
            if ((this.getExtendedState() & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH) {
                programLayer.setLocation((int) screenWidth/3,0);
            } else {
                programLayer.setLocation(0,0);
            }
        }
    }

    public final void optionSetup(JLabel label, JButton button, int xOffset, int yOffset){
        label.setBounds((int) screenWidth/3/2+xOffset, (int) screenHeight/2+yOffset, 125,50);
        label.setOpaque(true);
        label.setBackground(pastelPink);
        label.setVisible(false);
        phoneLayer.add(label, JLayeredPane.POPUP_LAYER);
        button.setBounds((int) screenWidth/3/2+xOffset, (int) screenHeight/2+yOffset, 125, 150);
        button.setBackground(pastelPink); //remove once image set (or not if invisible bg on image)
        button.addActionListener(this);
        button.setVisible(false);
        phoneLayer.add(button, JLayeredPane.MODAL_LAYER);
    }


    //keyboard actions
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER && !namer.getText().isEmpty() && !namer.getText().equals("Who might you be?") && !nameSubmitted){
            namer.setVisible(false);
            this.mainMenuVisibilities(true);
            nameSubmitted = true;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {}

    //button actions
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == entreesButton){
            //PUT ENTRÉES CLASS METHOD CALLS HERE
        }
        else if(e.getSource() == mainsButton){
            //PUT MAINS CLASS METHOD CALLS HERE
        }
        else if(e.getSource() == drinksButton){
            //PUT DRINKS CLASS METHOD CALLS HERE
        }
        else if(e.getSource() == dessertsButton){
            //PUT DESSERTS CLASS METHOD CALLS HERE
        }
        else if(e.getSource() == checkout){
            //PUT CHECKOUT CODE HERE
        }
    }

    public void mainMenuVisibilities(boolean visibility){
        greetings.setVisible(visibility);
        greetings.setText("Greetings and salutations, " + namer.getText() + "!");
        checkout.setVisible(visibility);
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