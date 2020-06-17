import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class QuickBrownFox {


    static String test = "3\n" +
            "The quick brown fox jumps over the lazy dog.\n" +
            "ZYXW\n" +
            ".,?!'\" 92384 abcde FGHIJ";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int testcases = s.nextInt();
        s.next();
        HashMap<Character, Boolean> characterBooleanHashMap = new HashMap<>();

        for (char c = 'A'; c <= 'Z'; c++) {
            characterBooleanHashMap.put(c, false);
        }

        while (testcases-- != 0) {
            String test = s.nextLine();
            test = test.toUpperCase();
            for (char c : test.toCharArray()
            ) {
                if (characterBooleanHashMap.containsKey(c)) {
                    characterBooleanHashMap.put(c, true);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Character, Boolean> e : characterBooleanHashMap.entrySet()) {
                if (!e.getValue()) {
                    if (sb.length() == 0) {
                        sb.append("missing ");
                    }
                    sb.append(e.getKey());
                }
            }
            if (sb.length() == 0) {
                System.out.println("pangram");
            } else {
                System.out.println(sb.toString().toLowerCase());
            }
            for (char c = 'A'; c <= 'Z'; c++) {
                characterBooleanHashMap.put(c, false);
            }
        }


    }
}
