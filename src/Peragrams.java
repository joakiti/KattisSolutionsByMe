import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Peragrams {

    static String test = "aabb\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        List<Integer> input = s.next().chars().sorted().boxed().collect(Collectors.toList());

        int missingPartners = 0;
        for (int i = 0; i < input.size(); i++) {
            int count = 1;
            while (i < input.size() - 1 && input.get(i).equals(input.get(i + 1))) {
                count++;
                i++;
            }
            if (count % 2 == 1) {
                missingPartners++;
            }
        }
        System.out.println(Math.max(missingPartners - 1, 0));
    }
}
