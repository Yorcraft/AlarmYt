import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Sound {
    public static void makeSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException{

        Scanner scanner = new Scanner(System.in);

        File file = new File("GD.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        String response = "";

        while(!response.equals("Q")) {
            System.out.println("P = play, T = skip, Q = quit");
            System.out.print("Enter your choice: ");

            response = scanner.next();
            response = response.toUpperCase();

            switch(response) {
                case ("P"): clip.start();
                    break;
                case ("Q"): clip.close();
                    break;
                case ("T"):
                    System.out.print("Enter the second you want to skip to");
                    int second = scanner.nextInt()*1000;
                    clip.setMicrosecondPosition(0);
                break;
                default: System.out.println("Not a valid response");
            }
        }
    }
}
