import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Parking {

    static String test = "2\n" +
            "4\n" +
            "24 13 89 37\n" +
            "6\n" +
            "7 30 41 14 39 42";
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        while (n-- != 0) {
            int stores = s.nextInt();
            ArrayList<Integer> storePositions = new ArrayList<>();
            while (stores-- != 0) {
                storePositions.add(s.nextInt());
            }
            Collections.sort(storePositions);
            System.out.println((storePositions.get(storePositions.size() - 1) - storePositions.get(0)) * 2 );
        }
    }
}
