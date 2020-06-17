import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bela {

    static String test = "2 S\n" +
            "TH\n" +
            "9C\n" +
            "KS\n" +
            "QS\n" +
            "JS\n" +
            "TD\n" +
            "AD\n" +
            "JH";
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Map<Character, Integer> dominantMap = Map.of(
                'A', 11,
                'K', 4,
                'Q', 3,
                'J', 20,
                'T', 10,
                '9', 14,
                '8', 0,
                '7', 0
        );
        Map<Character, Integer> nonDominantMap = Map.of(
                'A', 11,
                'K', 4,
                'Q', 3,
                'J', 2,
                'T', 10,
                '9', 0,
                '8', 0,
                '7', 0
        );
        int n = s.nextInt() * 4;
        char suit = s.next().toCharArray()[0];
        int total = 0;
        while (n-- != 0)  {
            String a = s.next();
            char dominant = a.toCharArray()[1];
            if (dominant == suit) {
                total += dominantMap.get(a.toCharArray()[0]);
            }
            else {
                total += nonDominantMap.get(a.toCharArray()[0]);
            }
        }
        System.out.println(total);
    }
}
