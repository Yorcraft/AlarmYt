import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Alarm {
        public static void main(String[] args) {
            int arrayLength = 6;

            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter your alarm in the following pattern: dd-MM-yyyy-HH-mm-ss");
            String userDateString = scan.nextLine();
            String[] userDate = userDateString.split("-");

            int[] userDateInt = new int[arrayLength];

            for(int i=0; i<arrayLength; i++)
            {
                userDateInt[i] = Integer.parseInt(userDate[i]);
            }
            while (true) {
                LocalDateTime date = LocalDateTime.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss");
                String formattedDate = date.format(myFormatObj);
                String[] dateSplit = formattedDate.split("-");



                int[] dateSplitInt= new int[arrayLength];

                for(int i=0; i<arrayLength; i++)
                {
                    dateSplitInt[i] = Integer.parseInt(dateSplit[i]);
                }

                if (dateSplitInt[0] == userDateInt[0] && dateSplitInt[1] == userDateInt[1] && dateSplitInt[2] == userDateInt[2] &&
                        dateSplitInt[3] == userDateInt[3] && dateSplitInt[4] == userDateInt[4] && dateSplitInt[5] == userDateInt[5])
                {
                    break;
                }
            }
            System.out.println("Get up fucker!!");
        }

}

