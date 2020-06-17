import java.util.List;
import java.util.Scanner;

public class Kornislav {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();
        int d = s.nextInt();
        List<Integer> values = new java.util.ArrayList<>(List.of(a, b, c, d));
        values.sort(Integer::compareTo);
        System.out.println(values.get(0)*values.get(2));
    }
}
