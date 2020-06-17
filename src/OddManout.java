import java.util.HashMap;
import java.util.Scanner;

public class OddManout {

    static String test = "3\n" +
            "3\n" +
            "1 2147483647 2147483647\n" +
            "5\n" +
            "3 4 7 4 3\n" +
            "5\n" +
            "2 10 2 10 5";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);


        int test = s.nextInt();
        int cases = 1;
        while (test-- != 0) {
            int invitations = s.nextInt();
            HashMap<Integer, Boolean> ids = new HashMap<>();
            while (invitations-- != 0) {
                int id = s.nextInt();
                if (ids.putIfAbsent(id, true) == null) {
                    continue;
                }
                else {
                    ids.remove(id);
                }
            }
            System.out.println("Case #" + cases + ": " + ids.entrySet().stream().findFirst().get().getKey());
            cases++;
        }
    }
}
