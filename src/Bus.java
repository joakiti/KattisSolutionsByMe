import java.util.Scanner;

public class Bus {

    static String test = "2\n" +
            "1\n" +
            "3\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        while (n-- != 0) {
            int p = s.nextInt() - 1;
            double passengers = 1;
            while (p -- != 0) {
                passengers += 0.5;
                passengers *= 2;
            }
            System.out.println((int)(passengers));
        }
    }
}
