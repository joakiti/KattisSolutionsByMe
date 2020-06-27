import java.util.*;

public class Flexible {

    static String test = "6 2\n" +
            "2 5\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int W = s.nextInt();
        int partitions = s.nextInt() + 1;
        int[] vals = new int[partitions + 1];
        for (int i = 1; i < partitions; i++) {
            vals[i] = s.nextInt();
        }
        vals[partitions] = W;
        Set<Integer> ans = new TreeSet<>();
        for (int i = 0; i < partitions + 1; i++) {
            for (int j = i + 1; j < partitions + 1; j++) {
                ans.add(vals[j] - vals[i]);
            }
        }
        System.out.println(Arrays.toString(ans.toArray()).replaceAll("\\[|]|,", ""));
    }
}
