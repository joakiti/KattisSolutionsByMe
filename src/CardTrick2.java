import java.util.Arrays;
import java.util.Scanner;

public class CardTrick2 {

    static String test = "3\n" +
            "1\n" +
            "5\n" +
            "6\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        while (n-- != 0) {
            int cards = s.nextInt();
            int[] deck = new int[cards];
            int currentPlace = 0;
            deck[1 % cards] = 1;
            currentPlace = 1 % cards;
            for (int i = 2; i <= deck.length; i++) {
                for (int j = 0; j <= i; j++) {
                    currentPlace = (currentPlace + 1) % cards;
                    while (deck[currentPlace] != 0) {
                        currentPlace = (currentPlace + 1) % cards;
                    }
                }
                deck[currentPlace] = i;
            }
            System.out.println(Arrays.toString(deck).replaceAll(",|\\[|]", ""));
        }
    }
}