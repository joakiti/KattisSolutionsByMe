import java.util.Scanner;

public class GreedyPolygons {

    static String test = "2\n" +
            "3 8 1 1\n" +
            "4 5 2 2";
    public static void main(String[] args) {
        Scanner s = new Scanner(test);

        int n = s.nextInt();

        while (n-- != 0) {
            int noOfSides = s.nextInt();
            int length = s.nextInt();
            int expansion = s.nextInt();
            int grabs = s.nextInt();
            double area = 0;
            for (int i = 0; i < grabs; i++) {
                double height = Math.sqrt(Math.pow(length, 2)+Math.pow(length/2., 2));
                area += 0.5 * (length * noOfSides * height);
                length -= expansion;
            }
            System.out.println(area);
        }

    }
}
