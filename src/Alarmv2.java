import java.io.File;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import javax.sound.sampled.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class Alarmv2 {
    public static void timer(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your alarm in the following pattern: dd-MM-yyyy-HH-mm-ss");
        String userDateString = scan.nextLine();
        LocalDateTime d2 = LocalDateTime.parse(userDateString, DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss"));
        LocalDateTime date = LocalDateTime.now();
        long milliseconds = date.until(d2, ChronoUnit.MILLIS);
        String day = LocalDate.now().getDayOfWeek().name(); //Will be used later
        System.out.println(milliseconds+ " ms");
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        timer();
        System.out.println("Alarm has been triggered sound check?");
        Sound.makeSound();
    }

}

