import java.util.Scanner;

public class SpeedLimit {

    static String test = "3\n" +
            "20 2\n" +
            "30 6\n" +
            "10 7\n" +
            "2\n" +
            "60 1\n" +
            "30 5\n" +
            "4\n" +
            "15 1\n" +
            "25 2\n" +
            "30 3\n" +
            "10 5\n" +
            "-1";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (s.hasNext()) {
            int n = s.nextInt();
            if (n == -1) {
                break;
            }
            int distanceDriven = 0;
            int hoursDriven = 0;
            while (n-- != 0) {
                int miles = s.nextInt();
                int hours = s.nextInt();
                hours = hours - hoursDriven;
                hoursDriven += hours;
                distanceDriven += miles*hours;
            }
            System.out.println(distanceDriven +  " miles");
        }
    }
}
