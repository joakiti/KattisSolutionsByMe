import java.util.Scanner;

public class Spavanac {


    static String test = "10 10\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int hours = s.nextInt();
        int minuttes = s.nextInt();
        int entiresDayInMinuttes = 24*60;

        int hoursInMinuttes = hours*60;

        int converted = hoursInMinuttes + minuttes - 45 + entiresDayInMinuttes;
        if (converted < 1440) {
            int convertedMinuttes = converted % 60;
            int convertedHours = (converted / 60);
            System.out.println(convertedHours + " " + convertedMinuttes);
        }
        else if (converted > 1440) {
            int convertedMinuttes = converted % 60;
            int convertedHours = (converted / 60) - 24;
            System.out.println(convertedHours + " " + convertedMinuttes);
        }


    }
}
