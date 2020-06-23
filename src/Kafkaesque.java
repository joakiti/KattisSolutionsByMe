import java.util.Scanner;

public class Kafkaesque {

    static String test = "8\n" +
            "8\n" +
            "7\n" +
            "6\n" +
            "5\n" +
            "4\n" +
            "3\n" +
            "2\n" +
            "1\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int last = Integer.MIN_VALUE;
        int ans = 1;

        while (n-- != 0) {
            int next = s.nextInt();
            if (next < last) {
                ans++;
            }
            last = next;
        }
        System.out.println(ans);
    }
}
