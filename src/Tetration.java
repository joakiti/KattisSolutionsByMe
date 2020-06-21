import java.util.*;

public class Tetration {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        double n = s.nextDouble();

        System.out.println(Math.pow(n, 1/(double)n));
    }
}