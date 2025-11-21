import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class Main {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        new Display();

        //File bgMusic = new File(screen.getClass().getResource("Banana Milkshake.wav"));
        File bgMusic = new File("src/Banana Milkshake.wav");

        try {
            AudioInputStream bgStream = AudioSystem.getAudioInputStream(bgMusic);
            Clip bgClip = AudioSystem.getClip();
            bgClip.open(bgStream);
            bgClip.loop(-1);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void restart(){
        new Display();
    }
}