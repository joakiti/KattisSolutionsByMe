import java.util.Scanner;

public class Ladder {

    static String test = "500 70\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        double h = s.nextDouble();
        double angle = s.nextDouble();

        System.out.println((int) Math.ceil (h/Math.sin(Math.toRadians(angle))));
    }
}
