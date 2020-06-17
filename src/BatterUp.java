import java.util.Scanner;

public class BatterUp {

    static String test = "3\n" +
            "3 0 2\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int count = n;

        int total = 0;
        while (n-- != 0) {
            int run = s.nextInt();
            if (run < 0) {
                count--;
            }
            else {
                total += run;
            }
        }
        System.out.println(total/(double) count);
    }
}
