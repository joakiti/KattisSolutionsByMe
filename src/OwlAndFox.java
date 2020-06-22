import java.util.Arrays;
import java.util.Scanner;

public class OwlAndFox {

    static String test = "4\n" +
            "30\n" +
            "199\n" +
            "1000\n" +
            "1520\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        while (n-- != 0) {
            char[] p = s.next().toCharArray();
            for (int i = p.length - 1; i >= 0; i--) {
                if (p[i] > 48) {
                    p[i]--;
                    break;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < p.length; i++) {
                sb.append(p[i]);
            }
            System.out.println(Integer.parseInt(sb.toString()));
        }
    }
}
