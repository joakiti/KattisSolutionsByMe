import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Karte {

    static String test = "P01K02H03H04\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);


        String poker = s.next();
        HashMap<Character, Integer> counts = new HashMap<>();
        HashSet<String> duplicates = new HashSet<>();
        for (int i = 0; i < poker.length(); i += 3) {
            char suit = poker.charAt(i);
            char valOne = poker.charAt(i + 1);
            char valTwo = poker.charAt(i + 2);
            String val = Character.toString(suit) + valOne + valTwo;
            counts.put(suit, counts.getOrDefault(suit, 0) + 1);
            if (duplicates.contains(val)) {
                System.out.println("GRESKA");
                System.exit(0);
            }
            duplicates.add(val);
        }
        System.out.printf("%d %d %d %d",
                13 - counts.getOrDefault('P', 0),
                13 - counts.getOrDefault('K', 0),
                13 - counts.getOrDefault('H', 0),
                13 - counts.getOrDefault('T', 0));
    }
}
