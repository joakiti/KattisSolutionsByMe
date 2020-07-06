import java.util.ArrayList;
import java.util.Scanner;

public class Statistics {

    static String test = "2 4 10\n" +
            "9 2 5 6 4 5 9 2 1 4\n" +
            "7 6 10 1 2 5 10 9\n" +
            "1 9\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testCounter = 1;
        while (s.hasNext()) {
            int count = s.nextInt();
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < count; i++) {
                int v = s.nextInt();
                min = Math.min(v, min);
                max = Math.max(v, max);
            }
            System.out.printf("Case %d: %d %d %d\n", testCounter, min, max, max-min);
            testCounter++;
        }
    }
}
