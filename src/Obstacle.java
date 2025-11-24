import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

@SuppressWarnings("LeakingThisInConstructor")
public class Obstacle extends JLabel{
    private final Toolkit toolkit = Toolkit.getDefaultToolkit();
    private final Dimension screenSize = toolkit.getScreenSize();
    final double screenWidth = screenSize.getWidth();
    final double screenHeight = screenSize.getHeight();

    int y = -125;
    int x;
    int pictureNo = 0;
    int frameCounter = 0;
    private static int noOfObstacles = 0;
    
    public Obstacle(Minigame minigame) {
        switch ((int)(Math.random()*(3)+1)){
            case 1:
                 x = 3/2-213;
            case 2:
                 x = (int)screenWidth/3/2-63;
            case 3:
                 x = (int)screenWidth/3/2+87;
        }
        this.setBounds(x,y,100,100);
        this.setOpaque(true);
        this.setIcon(minigame.screen.cart.get(pictureNo).getImage());
        pictureNo++;
        if (pictureNo >= minigame.screen.cart.size()){
            pictureNo = 0;
        }
        minigame.add(this, JLayeredPane.MODAL_LAYER);
        noOfObstacles++;

        Timer moveTimer = new Timer(30, (ActionEvent e) -> {
            y+=20;
            if (!minigame.lost){
                if (y >= (int)screenHeight+125 && !minigame.won) {
                    y = -125;
                    switch ((int)( Math.random()*(3)+1)){
                        case 1:
                             x = (int)screenWidth/3/2-213;
                        case 2:
                             x = (int)screenWidth/3/2-63;
                        case 3:
                             x = (int)screenWidth/3/2+87;
                    }
                }
                this.setLocation(x,y);
                this.setIcon(minigame.screen.cart.get(pictureNo).getImage());
                pictureNo++;
                if (pictureNo >= minigame.screen.cart.size()){
                    pictureNo = 0;
                }
                minigame.screen.update();
                if (this.getBounds().intersects(minigame.player.getBounds())){
                    minigame.lost = true;
                }
                if (frameCounter == 310 && !minigame.won){
                    new Obstacle(minigame);
                }
                frameCounter++;
                if (noOfObstacles >= 5){
                    minigame.won = true;
                }
            }
        });
        moveTimer.start();
    }
}
