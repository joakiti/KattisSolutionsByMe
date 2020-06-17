import java.util.Scanner;
import java.util.stream.IntStream;

public class Chanukah {

    static String test = "3\n" +
            "1 8\n" +
            "2 1\n" +
            "3 10";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        while (n-- != 0) {
            int id = s.nextInt();
            int x = s.nextInt();
            int sum = IntStream.rangeClosed(1,x).sum() + x;
            System.out.println(id + " "+ sum);
        }
    }
}
