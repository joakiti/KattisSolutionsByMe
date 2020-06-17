import java.util.Scanner;

public class AmazingHumanCannonball {

    static String test = "11\n" +
            "19 45 20 9 12\n" +
            "20 45 20 9 12\n" +
            "25 45 20 9 12\n" +
            "20 43 20 9 12\n" +
            "20 47.5 20 9 12\n" +
            "20 45 17 9 12\n" +
            "20 45 24 9 12\n" +
            "20 45 20 10 12\n" +
            "20 45 20 9 11\n" +
            "20 45 20 9.0 11.5\n" +
            "20 45 18.1 9 12";
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        while (n-- != 0) {
            double v0 = s.nextDouble();
            double angle = s.nextDouble();
            double x1 = s.nextDouble();
            double h1 = s.nextDouble();
            double h2 = s.nextDouble();
            double time = x1 / (v0*Math.cos(Math.toRadians(angle)));
            double y = yAtTimeT(time, v0,x1, angle);
            if (y > h1 + 1 && y < h2 - 1) {
                System.out.println("Safe");
            }
            else {
                System.out.println("Not Safe");
            }
        }
    }

    static double yAtTimeT(double t, double v0, double x1, double angle) {
        return (v0 * t * Math.sin(Math.toRadians(angle))) - (0.5 * 9.81 * Math.pow(t, 2));
    }
}
