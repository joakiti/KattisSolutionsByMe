import java.util.Scanner;
import java.util.stream.IntStream;

public class BossBattle {

    static String test = "7\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int c = s.nextInt();
        if (c <= 3) {
            System.out.println(1);
            System.exit(0);
        }
        else {
            System.out.println(c - 2);
        }

    }
}
