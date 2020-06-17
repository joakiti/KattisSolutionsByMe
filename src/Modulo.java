import java.util.HashSet;
import java.util.Scanner;

public class Modulo {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        HashSet<Integer> values = new HashSet<>();

        while (s.hasNext()) {
            values.add(s.nextInt() % 42);
        }
        System.out.println(values.size());
    }
}
