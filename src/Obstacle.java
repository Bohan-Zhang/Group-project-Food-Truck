import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

import javax.swing.*;

@SuppressWarnings("LeakingThisInConstructor")
public class Obstacle extends JLabel{
    private final Toolkit toolkit = Toolkit.getDefaultToolkit();
    private final Dimension screenSize = toolkit.getScreenSize();
    final double screenWidth = screenSize.getWidth();
    final double screenHeight = screenSize.getHeight();

    int y = -125;
    int x;
    int frameCounter = 0;
    boolean over = false;
    private static int noOfObstacles = 0;
    private final int id;
    
    public Obstacle(Minigame minigame) {
        switch ((int)(Math.random()*(3)+1)){
            case 1 -> x = (int)screenWidth/3/2-213;
            case 2 -> x = (int)screenWidth/3/2-63;
            case 3 -> x = (int)screenWidth/3/2+87;
        }
        this.setBounds(x,y,125,125);
        this.setIcon((new ImageIcon(Objects.requireNonNull(getClass().getResource("/img/car.png")))));
        minigame.add(this, JLayeredPane.MODAL_LAYER);
        noOfObstacles++;
        id = noOfObstacles;

        Timer moveTimer = new Timer(30, (ActionEvent e) -> {
            y+=20;
            if (!minigame.lost){
                if (y >= (int)screenHeight+125 && !minigame.won) {
                    y = -125;
                    switch ((int)( Math.random()*(3)+1)){
                        case 1 -> x = (int)screenWidth/3/2-213;
                        case 2 -> x = (int)screenWidth/3/2-63;
                        case 3 -> x = (int)screenWidth/3/2+87;
                    }
                }
                this.setLocation(x,y);
                minigame.screen.update();
                if (frameCounter == 310 && !minigame.won){
                    new Obstacle(minigame);
                }
                frameCounter++;
                
                if (this.getBounds().intersects(minigame.player.getBounds())){
                    minigame.lose();
                }
                if (noOfObstacles >= 5){
                    minigame.won = true;
                }
                if (id == 5 && y >= (int)screenHeight+125){
                    if (!over){
                    minigame.win();
                    over = true;
                    }
                }
            }
        });
        moveTimer.start();
    }
}
