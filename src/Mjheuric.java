import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Mjheuric {

    static String test = "2 1 5 3 4\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] values = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] expected = IntStream.rangeClosed(1, 5).toArray();
        major:
        while (true) {
            for (int i = 0; i < 4; i++) {
                if (values[i] > values[i+1]) {
                    int temp = values[i];
                    values[i] = values[i+1];
                    values[i + 1] = temp;
                    System.out.println(Arrays.toString(values).replaceAll("\\[|]|,", ""));
                }
            }
            for (int i = 0; i < values.length; i++) {
                if (values[i] != expected[i]) {
                    continue major;
                }
            }
            break;
        }
    }
}
