package nwerc2021;

import java.util.List;
import java.util.Scanner;

public class DragonBalls {

    static Tuple constraints = new Tuple((int) Math.pow(10, 6), (int) Math.pow(10, 6));

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        DragonBalls solver = new DragonBalls();


        Tuple startingPoint = new Tuple(constraints.x / 2, constraints.y / 2);

        int n = s.nextInt();

        while (n -- > 0) {

            long L = 0; long R = constraints.x;
            long y = 0;
            long lastDistance = -1;
            long newDistance = -2;
            long x;
            while (lastDistance != newDistance) {
                long mid = L + (R - L) / 2;
                long midLeft = L + mid/2;
                long midRight = R - mid/2;
                System.out.println(midLeft + " " + y);
                long distanceLeft = s.nextLong();
                System.out.println(midRight + " " + y);
                long distanceRight = s.nextLong();
                if (distanceLeft < distanceRight) {
                    lastDistance = newDistance;
                    newDistance = distanceLeft;
                    R = mid;
                    x = midLeft;
                }
                else if (distanceRight < distanceLeft) {
                    lastDistance = newDistance;
                    newDistance = distanceLeft;
                    L = mid;
                    x = midRight;
                }

            }
            //solver.rec(s, startingPoint, startingPoint);
        }

    }

    private void rec(Scanner s, Tuple startingPoint, Tuple constraints) {
        Tuple top = up(startingPoint, constraints);
        Tuple down = down(startingPoint, constraints);
        Tuple left = left(startingPoint, constraints);
        Tuple right = right(startingPoint, constraints);

        System.out.println(top);
        long topDist = s.nextLong();
        System.out.println(down);
        long downDist = s.nextLong();
        System.out.println(left);
        long leftDist = s.nextLong();
        System.out.println(right);
        long rightDist = s.nextLong();

        if (List.of(topDist, downDist, leftDist, rightDist).stream().anyMatch(aDouble -> aDouble == 0)) {
            return;
        }
        else if (topDist <= downDist && topDist <= leftDist && topDist <= rightDist) {
            rec(s, top, new Tuple(constraints.x, constraints.y / 2));
        }
        else if (downDist <= topDist && downDist <=  leftDist && downDist <= rightDist) {
            rec(s, down, new Tuple(constraints.x, constraints.y / 2));
        }
        else if (leftDist <= downDist && leftDist <=  topDist && leftDist <= rightDist) {
            rec(s, left, new Tuple(constraints.x / 2, constraints.y));
        }
        else if (rightDist <= downDist && rightDist <= topDist && rightDist <= leftDist) {
            rec(s, right, new Tuple(constraints.x / 2, constraints.y));
        }
    }

    public static Tuple up(Tuple point, Tuple constraints) {
        return new Tuple(point.x, point.y + constraints.y / 2);
    }
    public static Tuple down(Tuple point,Tuple constraints) {
        return new Tuple(point.x, point.y - constraints.y / 2);
    }
    public static Tuple left(Tuple point, Tuple constraints) {
        return new Tuple(constraints.x - constraints.x / 2, point.y);
    }
    public static Tuple right(Tuple point, Tuple constraints) {
        return new Tuple(point.x + constraints.x / 2, point.y);
    }

    public static class Tuple {
        int x,y;

        @Override
        public String toString() {
            return x + " " + y;
        }

        public Tuple(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
