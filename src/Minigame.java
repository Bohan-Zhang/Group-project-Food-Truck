import java.awt.*;
import java.util.Objects;
import java.awt.event.ActionEvent;
import javax.swing.*;

@SuppressWarnings("LeakingThisInConstructor")
public class Minigame extends JLayeredPane{
    private final Toolkit toolkit = Toolkit.getDefaultToolkit();
    private final Dimension screenSize = toolkit.getScreenSize();
    final double screenWidth = screenSize.getWidth();
    final double screenHeight = screenSize.getHeight();

    int x = (int)screenWidth/3/2-63;
    boolean lost = false;
    boolean won = false;
    boolean ended = false;

    Display screen;
    JLabel street;
    JLabel chateau;
    JLabel player;

    public Minigame(Display screen){
        this.screen = screen;
        screen.getContentPane().setBackground(new Color(100,100,100));


        this.setBounds(0,0,(int)screenWidth/3,(int)screenHeight);
        screen.programLayer.add(this, JLayeredPane.PALETTE_LAYER);

        street = new JLabel();
        street.setBounds((int)screenWidth/3/2-250,0,500,1000);
        street.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/img/Road.gif"))));
        this.add(street, JLayeredPane.DEFAULT_LAYER);

        chateau = new JLabel();
        chateau.setBounds((int)screenWidth/3/2-250,0,500,1000);
        chateau.setVisible(false);
        this.add(chateau, JLayeredPane.PALETTE_LAYER);

        player = new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("/img/Player.png"))));
        player.setBounds(x,(int)screenHeight-200,125,125);
        this.add(player, JLayeredPane.MODAL_LAYER);

        new Obstacle(this);
    }

    public void movePlayerLeft(){
        if (x >= (int)screenWidth/3/2-63 && !lost){
            x-=150;
            player.setLocation(x,(int)screenHeight-200);
            screen.update();
        }
    }

    public void movePlayerRight(){
        if (x <= (int)screenWidth/3/2-63 && !lost){
            x+=150;
            player.setLocation(x,(int)screenHeight-200);
            screen.update();
        }
    }

    public void win(){
        chateau.setVisible(true);
        chateau.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/img/Chateau.gif"))));
        Timer endTimer = new Timer(7000, (ActionEvent e) -> {
            if (!ended){
                this.setVisible(false);
                JLabel success = new JLabel("<html><body>You sucessfully obtained your food, and enjoyed it's delicate and exhuberant taste<html>");
                success.setForeground(new Color (255,255,255));
                success.setBounds((int)screenWidth/3/2-140, (int) screenHeight/2, 300,50);
                screen.add(success);
                screen.getContentPane().setBackground(new Color(0,0,0));
                ended = true;
            }
        });
        endTimer.start();
    }

    public void lose(){
        lost = true;
        this.setVisible(false);
        JLabel fail = new JLabel("You never got your food...", SwingConstants.CENTER);
        fail.setForeground(new Color (255,255,255));
        fail.setBounds((int)screenWidth/3/2-150, (int) screenHeight/2, 300,50);
        screen.add(fail);
        screen.getContentPane().setBackground(new Color(150,0,0));
    }

}
