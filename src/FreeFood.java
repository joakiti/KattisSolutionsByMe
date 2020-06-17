import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.IntStream.concat;

public class FreeFood {

    static String test = "3\n" +
            "10 14\n" +
            "13 17\n" +
            "25 26";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        IntStream freeFoodDays = IntStream.builder().build();
        while (n-- !=0) {
            int a = s.nextInt();
            int b = s.nextInt();
            freeFoodDays = IntStream.concat(IntStream.rangeClosed(a, b), freeFoodDays);
        }
        System.out.println(freeFoodDays.distinct().count());

    }
}
