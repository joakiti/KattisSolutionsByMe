import java.util.ArrayList;
import java.util.Scanner;

public class GrandpasCheckerBoard {

    static String test = "6\n" +
            "BWBWWB\n" +
            "WBWBWB\n" +
            "WBBWBW\n" +
            "BBWBWW\n" +
            "BWWBBW\n" +
            "WWBWBB\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        s.nextLine();
        char[][] arr = new char[n][n];

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            int blackSqaures = 0;
            int whiteSquares = 0;
            ArrayList<Character> consecutive = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 'W') {
                    whiteSquares++;
                    if (!consecutive.contains('W')) {
                        consecutive = new ArrayList<>();
                    }
                    consecutive.add('W');
                } else {
                    blackSqaures++;
                    if (!consecutive.contains('B')) {
                        consecutive = new ArrayList<>();
                    }
                    consecutive.add('B');
                }
                if (consecutive.size() >= 3) {
                    System.out.println(0);
                    System.exit(0);
                }
            }
            if (blackSqaures != whiteSquares) {
                System.out.println(0);
                System.exit(0);
            }
        }
        for (int i = 0; i < n; i++) {
            int blackSqaures = 0;
            int whiteSquares = 0;
            ArrayList<Character> consecutive = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (arr[j][i] == 'W') {
                    whiteSquares++;
                    if (!consecutive.contains('W')) {
                        consecutive = new ArrayList<>();
                    }
                    consecutive.add('W');
                } else {
                    blackSqaures++;
                    if (!consecutive.contains('B')) {
                        consecutive = new ArrayList<>();
                    }
                    consecutive.add('B');
                }
                if (consecutive.size() >= 3) {
                    System.out.println(0);
                    System.exit(0);
                }
            }
            if (blackSqaures != whiteSquares) {
                System.out.println(0);
                System.exit(0);
            }
        }
        System.out.println(1);
    }
}
