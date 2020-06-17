import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Kleptography {

    static String test = "5 16\n" +
            "again\n" +
            "pirpumsemoystoal";

    public static void main(String[] args) {
        Scanner s = new Scanner(test);
        int n = s.nextInt();
        int m = s.nextInt();
        String a = s.next(); String b = s.next();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m - n; i++) {
            sb.append(" ");
        }
        a = sb.toString() + a;
        char[] solution = a.toCharArray();
        for (int i = m-1; i > n - 1 ; i--) {
            solution[i - n] = (char) ('a' + (26 + b.charAt(i) - solution[i]) % 26);
        }
        for (char c : solution) System.out.print(c);

    }
}
