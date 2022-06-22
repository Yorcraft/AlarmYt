import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class Alarm {
    public static void timer(){
        int arrayLength = 6;

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your alarm in the following pattern: dd-MM-yyyy-HH-mm-ss");
        String userDateString = scan.nextLine();
        String[] userDate = userDateString.split("-"); //user Input is converted to a String array
        int[] userDateInt = new int[arrayLength];

        for(int i=0; i<arrayLength; i++)
        {
            userDateInt[i] = Integer.parseInt(userDate[i]); //String array gets parsed
        }
            String day = LocalDate.now().getDayOfWeek().name(); //Will be used later
            LocalDateTime date = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss");
            String formattedDate = date.format(myFormatObj);
            String[] dateSplit = formattedDate.split("-");
            int[] dateSplitInt= new int[arrayLength];
            for(int i=0; i<arrayLength; i++)
            {
                dateSplitInt[i] = Integer.parseInt(dateSplit[i]);
            }
            int yyyy = userDateInt[2] - dateSplitInt[2];
            int yearMultiplier = 365;                   //leap years only work if the targeted year is a leap year
            int checkForleap = userDateInt[2]-2000;
            while(true)
            {
                if(checkForleap>0)
                {
                    checkForleap = checkForleap-4;
                }
                else if (checkForleap==0)
                {
                    yearMultiplier = 366;
                    break;
                }
                else
                {
                    break;
                }

            }

            int myear = yyyy*yearMultiplier*24*60*60*1000;                          //fix later
            int milliseconds = yyyy*yearMultiplier*24*60*60*1000+userDateInt[0]*24*60*60*1000+userDateInt[3]*60*1000+ userDateInt[4]*60*1000+userDateInt[5]*1000; //fix later

        System.out.println(myear); //fix later
        System.out.println("alarm in: "+milliseconds+" seconds");
        System.out.println(myear);

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

