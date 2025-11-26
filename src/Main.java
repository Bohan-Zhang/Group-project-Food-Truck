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

    public static String addZeroes(double number) {
        String numString = Double.toString(number);
        if (numString.indexOf(".") == numString.length() - 2){ // If the decimal point is the second last character 
            numString += "0";
        } else if ((numString.length() - numString.indexOf(".") + 1) >= 4){ // Removing trailing zeroes for some reason
            numString = numString.substring(0, numString.indexOf(".") + 3);
            
        }
        return numString;
    }
}