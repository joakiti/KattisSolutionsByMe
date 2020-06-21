import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BoatParts {

    static String test = "3 5\n" +
            "left_oar\n" +
            "right_oar\n" +
            "left_oar\n" +
            "hull\n" +
            "right_oar";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int p = s.nextInt();

        int days = 1;
        HashSet<String> parts = new HashSet<>();
        while (p-- != 0) {
            parts.add(s.next());
            if (parts.size() >= n) {
                System.out.println(days);
                System.exit(0);
            }
            days++;
        }
        System.out.println("paradox avoided");
    }
}
