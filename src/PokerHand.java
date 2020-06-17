import java.security.Key;
import java.util.*;

public class PokerHand {

    static String test = "AC AD AH AS KD\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        HashMap<Character, Integer> hand = new HashMap<>();
        while (s.hasNext()) {
            String b = s.next();

            hand.put(b.charAt(0), hand.getOrDefault(b.charAt(0), 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(hand.entrySet());
        list.sort(Map.Entry.comparingByValue());
        System.out.println(list.get(list.size()-1).getValue());
    }
}
