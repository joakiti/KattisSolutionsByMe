import java.util.Scanner;

public class GoatRope {

    static String test = "7 3 0 0 5 4\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int goatX = s.nextInt();
        int goatY = s.nextInt();

        Pair first = new Pair(s.nextInt(), s.nextInt());
        Pair second = new Pair(s.nextInt(), s.nextInt());

        double x;
        double y;
        if (goatX >= first.x && goatX <= second.x) {
            x = first.x + Math.abs(goatX - first.x);
        }
        else if (goatX < first.x) {
            x = first.x;
        }
        else {
            x = second.x;
        }
        if (goatY >= first.y && goatY <= second.y) {
            y = first.y + Math.abs(goatY - first.y);
        }
        else if (goatY < first.y) {
            y = first.y;
        }
        else {
            y = second.y;
        }
        System.out.println(distance(x,y,goatX, goatY));
    }

    static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
    }

    static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.y = y;
            this.x = x;
        }
    }
}
