import java.util.Scanner;

public class Trik {

    static String test = "AB";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[] position = new int[]{1, 0, 0};

        String moves = s.next();
        for (char c :
                moves.toCharArray()) {
            if (c == 'A') {
                int temp = position[0];
                position[0] = position[1];
                position[1] = temp;
            }
            else if (c == 'B') {
                int temp = position[1];
                position[1] = position[2];
                position[2] = temp;
            }
            else if (c == 'C') {
                int temp = position[0];
                position[0] = position[2];
                position[2] = temp;
            }
        }
        for (int i = 0; i < position.length; i++) {
            if (position[i] == 1) {
                System.out.println(i + 1);
            }
        }
    }
}
