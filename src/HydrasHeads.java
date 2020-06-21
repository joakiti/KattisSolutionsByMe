import java.util.Scanner;

public class HydrasHeads {

    static String test = "3 3\n" +
            "1 1\n" +
            "0 0\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (s.hasNext()) {
            int moves = 0;
            int heads = s.nextInt();
            int tails = s.nextInt();
            if (heads == 0 || tails == 0) {
                System.exit(0);
            }
            if (heads % 2 != 0) {
                if (tails < 2) {
                    tails++;
                    moves++;
                }
                tails -= 2;
                heads++;
                moves++;
            }
            moves += heads / 2;
            heads = 0;
            if (tails % 4 != 0) {
                moves += 4 - (tails % 4);
                tails += 4 - (tails % 4);
            }
            moves += tails / 2;
            heads += tails / 2;
            moves += heads / 2;
            System.out.println(moves);
        }
    }
}
