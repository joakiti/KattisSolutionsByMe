import java.util.HashMap;
import java.util.Scanner;

public class SevenWonders {

    static String test = "TTCCGG\n\n";
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String line = s.next();

        int[] cards = new int[100];

        for (char c :
                line.toCharArray()) {
            cards[c]++;
        }

        int gcd = Math.min(Math.min(cards['C'], cards['T']), cards['G']);
        int totalPoints = gcd*7;
        totalPoints += Math.pow(cards['C'], 2) + Math.pow(cards['T'], 2) + Math.pow(cards['G'], 2);
        System.out.println(totalPoints);
    }

}
