import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MissingNumbers {

    static String test = "1 99";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Integer> values = new ArrayList<>();
        s.nextInt();
        while (s.hasNext()) {
            values.add(s.nextInt());
        }
        List<Integer> vals = IntStream.rangeClosed(1, values.get(values.size() - 1)).boxed().collect(Collectors.toList());
        vals.removeAll(values);
        vals.sort(Integer::compareTo);
        if (vals.size() == 0) {
            System.out.println("good job");
        }
        else {
            for (Integer v : vals) {
                System.out.println(v);
            }
        }
    }
}
