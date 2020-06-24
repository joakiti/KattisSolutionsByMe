import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

public class HittingTheTargetrs {

    static String test = "3\n" +
            "rectangle 1 1 10 5\n" +
            "circle 5 0 8\n" +
            "rectangle -5 3 5 8\n" +
            "5\n" +
            "1 1\n" +
            "4 5\n" +
            "10 10\n" +
            "-10 -1\n" +
            "4 -3\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        ArrayList<Shape> valsSortedByX = new ArrayList<>();
        int n = s.nextInt();
        while (n-- != 0) {
            String figure = s.next();
            if (figure.equals("rectangle")) {
                Square sq = new Square(new Point(s.nextInt(), s.nextInt()), new Point(s.nextInt(), s.nextInt()));
                valsSortedByX.add(sq);
            } else {
                Circle c = new Circle(new Point(s.nextInt(), s.nextInt()), s.nextInt());
                valsSortedByX.add(c);
            }
        }
        n = s.nextInt();
        while (n-- != 0) {
            int count = 0;
            Point p = new Point(s.nextInt(), s.nextInt());
            for (Shape shape :
                    valsSortedByX) {
                 if (shape.isInside(p)) {
                    count++;
                };
            }
            System.out.println(count);
        }
    }
}

abstract class Shape {

    Point x1y1 = new Point();
    Point x2y2 = new Point();

    abstract boolean isInside(Point p);

}

class Circle extends Shape {

    double radius;

    @Override
    public String toString() {
        return x2y2.toString();
    }

    Circle(Point x1y1, double r) {
        this.x2y2.setLocation(x1y1);
        radius = r;
    }

    @Override
    public boolean isInside(Point p) {
        double dist = (radius * radius) - (Math.pow(x2y2.x - p.x, 2) + Math.pow(x2y2.y - p.y, 2));
        return dist >= 0;
    }
}

class Square extends Shape {

    Square(Point x1y1, Point x2y2) {
        this.x1y1.setLocation(x1y1);
        this.x2y2.setLocation(x2y2);
    }

    @Override
    public boolean isInside(Point p) {
        return p.x >= x1y1.x && p.x <= x2y2.x && p.y >=x1y1.y && p.y <= x2y2.y;
    }
}