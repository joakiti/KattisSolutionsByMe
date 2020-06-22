import java.util.Scanner;

public class UnlockPattern {

    static String test = "6 1 9\n" +
            "5 2 8\n" +
            "4 3 7\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[][] pin = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pin[i][j] = s.nextInt();
            }
        }
        int x = 0; int y = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (pin[i][j] == 1) {
                    x = i;
                    y = j;
                    j = 3; //terminate
                    i = 3;
                }
            }
        }
        double distance = 0;
        nextId:
        for (int id = 2; id <= 9; id++) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (pin[i][j] == id) {
                        distance += Math.sqrt(Math.pow(x - i, 2) + Math.pow(y - j, 2));
                        x = i;
                        y = j;
                        continue nextId;
                    }
                }
            }
        }
        System.out.println(distance);
    }
}
