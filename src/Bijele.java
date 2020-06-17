import java.util.ArrayList;
import java.util.Scanner;

public class Bijele {

    static String test = "0 1 2 2 2 7\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        ArrayList<Integer> pieces = new ArrayList<>();
        while  (s.hasNext()) {
            pieces.add(s.nextInt());
        }
        int[] goal = new int[] {
                1,
                1,
                2,
                2,
                2,
                8
        };
        for (int i = 0; i < pieces.size() ; i++) {
            System.out.print(goal[i] - pieces.get(i) + " ");
        }
    }
}
