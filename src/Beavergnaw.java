import java.util.Scanner;

public class Beavergnaw {

    static String test = "10 250\n" +
            "20 2500\n" +
            "25 7000\n" +
            "50 50000\n" +
            "0 0";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (true) {
            int D = s.nextInt();
            double v = s.nextInt() * 1.5;

            if (D == 0 && v == 0) {
                System.exit(0);
            }

            double radius = D/(double) 2;
            double volume = Math.pow(radius, 2) * Math.PI * D;
            volume -= v; // We compute the volume of the cylinder, and remove what has already been eaten.
            volume /= Math.PI;
            volume /= 2;
            volume = Math.cbrt(volume);
            System.out.println(2*volume);

        }
    }
}
