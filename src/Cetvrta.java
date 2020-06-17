import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Cetvrta {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        ArrayList<Integer> xPoints = new ArrayList<>();
        ArrayList<Integer> yPoints = new ArrayList<>();

        while (s.hasNext()) {
            xPoints.add(s.nextInt());
            yPoints.add(s.nextInt());
        }
        int uniqueX = 0;
        for (Integer x : xPoints) {
            if (Collections.frequency(xPoints, x ) == 1) {
                uniqueX = x;
            }
        }
        int uniqueY = 0;
        for (Integer y: yPoints) {
            if (Collections.frequency(yPoints, y ) == 1) {
                uniqueY = y;
            }
        }
        System.out.println(uniqueX + " " + uniqueY);
    }

}
