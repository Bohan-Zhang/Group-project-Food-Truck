import java.io.File;
import java.io.IOException;
import java.util.Objects;

import javax.sound.sampled.*;

public class Main {

    
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        Display screen = new Display();

        //File bgMusic = new File(screen.getClass().getResource("Banana Milkshake.wav"));
        File bgMusic = new File("src/Banana Milkshake.wav");
        AudioInputStream bgStream = AudioSystem.getAudioInputStream(bgMusic);

        try {
            Clip bgClip = AudioSystem.getClip();
            bgClip.open(bgStream);
            bgClip.loop(-1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}