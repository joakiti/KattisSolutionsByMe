import java.util.Scanner;

public class RoamingRomans {
    static String test = "20.267\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        double miles = s.nextDouble();

        System.out.println(Math.round(1000 * miles * (5280./4854.)));
    }
}
