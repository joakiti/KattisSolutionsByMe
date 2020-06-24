import java.util.Scanner;

public class HalfACookie {

    static String test = "10.0 5.0 0\n" +
            "5.5 5.0 5.0\n" +
            "8.0 3.0 4.5\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (s.hasNext()) {
            double R = s.nextDouble();
            double x = s.nextDouble();
            double y = s.nextDouble();
            double distance = (x * x + y * y);
            if (R * R - distance < 0) {
                System.out.println("miss");
                continue;
            }
            double h = R - Math.sqrt(distance);
            double partCircle = R * R * Math.acos((R - h) / R) - (R - h) * Math.sqrt(2 * R * h - h * h);
            double entireCircle = Math.PI * R * R;
            System.out.println(Math.max(entireCircle - partCircle, partCircle) + " " + Math.min(entireCircle - partCircle, partCircle));
        }
    }
}
