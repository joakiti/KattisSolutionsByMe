import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class ClosingTheLoop {

    static String test = "4\n" +
            "1\n" +
            "5B\n" +
            "4\n" +
            "6R 1B 7R 3B\n" +
            "7\n" +
            "5B 4R 3R 2R 5R 4R 3R\n" +
            "2\n" +
            "20B 20R\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        for (int i = 1; i <= n; i++) {
            LinkedList<Integer> blueRopes = new LinkedList<>();
            LinkedList<Integer> redRopes = new LinkedList<>();
            int segments = s.nextInt();
            int ans = 0;
            for (int j = 0; j < segments; j++) {
                String rope = s.next();
                int length = Integer.parseInt(rope.substring(0, rope.length() - 1));
                char color = rope.charAt(rope.length() - 1);
                if (color == 'R') {
                    redRopes.add(length);
                }
                else {
                    blueRopes.add(length);
                }
            }
            if (redRopes.size() == 0 || blueRopes.size() == 0) {
                System.out.printf("Case #%d: %d", i, 0);
                System.out.println();
                continue;
            }
            blueRopes.sort(Collections.reverseOrder());
            redRopes.sort(Collections.reverseOrder());
            while (redRopes.size() != 0 && blueRopes.size() != 0) {
                ans += (redRopes.poll() + blueRopes.poll());
                ans -= 2; // tie a knot
            }
            System.out.printf("Case #%d: %d", i, ans);
            System.out.println();
        }

    }
}
