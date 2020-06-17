import com.sun.source.tree.Tree;

import java.util.Scanner;
import java.util.TreeSet;

public class StackingCups {

    static String test = "3\n" +
            "red 10\n" +
            "10 blue\n" +
            "green 7";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        TreeSet<Cup> set = new TreeSet<>();
        while (n-- != 0) {
            String ifNumberThenHalf = s.next();
            String IfNumberThenNormal = s.next();
            try {
                int x = Integer.parseInt(IfNumberThenNormal);
                set.add(new Cup(ifNumberThenHalf, x));
            }
            catch (NumberFormatException e) {
                int x = Integer.parseInt(ifNumberThenHalf);
                set.add(new Cup(IfNumberThenNormal, x/2));
            }
        }
        for (Cup c :
                set) {
            System.out.println(c.color);
        }
    }

    private static class Cup implements Comparable<Cup> {

        String color;
        int radius;
        Cup(String color, int radius) {
            this.color = color;
            this.radius = radius;

        }

        @Override
        public int compareTo(Cup o) {
            return Integer.compare(radius, o.radius);
        }
    }
}
