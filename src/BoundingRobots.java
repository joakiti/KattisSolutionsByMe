import java.util.Scanner;

public class BoundingRobots {

    static String test = "3 3\n" +
            "1\n" +
            "u 1\n" +
            "4 5\n" +
            "2\n" +
            "u 3\n" +
            "r 4\n" +
            "10 10\n" +
            "4\n" +
            "r 30\n" +
            "d 30\n" +
            "l 25\n" +
            "u 5\n" +
            "0 0\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (s.hasNext()) {
            int w = s.nextInt();
            int l = s.nextInt();
            if (w == 0 || l == 0) {
                System.exit(0);
            }
            int commands = s.nextInt();
            int y = 0;
            int x = 0;
            int realX = 0;
            int realY = 0;
            while (commands-- != 0) {
                char command = s.next().charAt(0);
                int move = s.nextInt();
                if (command == 'u') {
                    y += move;
                    realY = Math.min(l-1,  realY + move);
                }
                else if (command == 'd') {
                    y -= move;
                    realY = Math.max(0,  realY - move);
                }
                else if (command == 'r') {
                    x += move;
                    realX = Math.min(w-1, realX + move);
                }
                else if (command == 'l') {
                    x -= move;
                    realX = Math.max(0, realX - move);
                }
            }
            System.out.printf("Robot thinks %d %d\n", x, y);
            System.out.printf("Actually at %d %d\n", realX, realY);
        }
    }
}
