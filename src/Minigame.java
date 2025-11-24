import java.awt.*;
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

    Display screen;
    JLabel street;
    JLabel player;

    public Minigame(Display screen){
        this.screen = screen;

        this.setBounds(0,0,(int)screenWidth/3,(int)screenHeight);
        screen.programLayer.add(this, JLayeredPane.PALETTE_LAYER);

        street = new JLabel();
        street.setBounds(0,0,(int)screenWidth/3,(int)screenHeight);
        street.setOpaque(true);
        street.setBackground(new Color(0,0,0));
        this.add(street, JLayeredPane.PALETTE_LAYER);

        player = new JLabel();
        player.setBounds(x,(int)screenHeight-200,125,125);
        player.setOpaque(true);
        player.setBackground(new Color(0,255,0));
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

}
