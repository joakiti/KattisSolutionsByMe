import java.util.Scanner;

public class Mirror {

    static String test = "2\n" +
            "2 2\n" +
            ".*\n" +
            "..\n" +
            "4 4\n" +
            "***.\n" +
            "**..\n" +
            "....\n" +
            "....\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        for (int z = 1; z <= n; z++) {
            int r = s.nextInt();
            int c = s.nextInt();
            char[][] solution = new char[r][c];
            for (int i = r - 1; i >= 0; i--) {
                solution[i] = new StringBuilder(s.next()).reverse().toString().toCharArray();
            }
            System.out.println("Test " + z);
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    System.out.print(solution[i][j]);
                }
                System.out.println();
            }
        }
    }
}
