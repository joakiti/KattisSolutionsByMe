package adv_algorithms.experiments;

import java.util.*;
import java.util.stream.Collectors;

public class QuadraticTableLookupFourSum {
    static String test = "5\n" +
            "4\n" +
            "-3\n" +
            "2\n" +
            "1\n" +
            "-7";

    public static void main(String[] args) {
        HashMap<Long, HashMap<Long, Long>> H = new HashMap<>();
        HashMap<Long, HashMap<Integer, Integer>> H2 = new HashMap<>();

        Scanner S = new Scanner(System.in);

        int N = Integer.parseInt(S.nextLine());
        long[] vals = new long[N];
        for (int i = 0; i < N; i += 1) {
            vals[i] = Long.parseLong(S.nextLine());
        }
        for (int i = 0; i < N; i++) {
            H.putIfAbsent(vals[i], new HashMap<>());
            for (int j = i + 1; j < N; j++) {
                H.get(vals[i]).put(vals[j], vals[i] + vals[j]);
                H2.putIfAbsent(vals[i] + vals[j], new HashMap<>());
                H2.get(vals[i] + vals[j]).put(j, i);
            }
        }
        // the variables are ordered l < k < j < i; sorry
        for (int i = 0; i < N; ++i)
            for (int j = i + 1; j < N; j += 1) {// i goes through {0, ..., N-1}
                Long key = H.get(vals[i]).get(vals[j]);
                int finalI = i;
                int finalJ = j;
                if (H2.containsKey(-key)) {
                    var solution =  H2.get(-key)
                            .entrySet()
                            .stream()
                            .filter(integerIntegerEntry ->
                                    integerIntegerEntry.getKey() != finalI &&
                                            integerIntegerEntry.getKey() != finalJ &&
                                            integerIntegerEntry.getValue() != finalJ &&
                                            integerIntegerEntry.getValue() != finalI ).findAny();
                    if (solution.isPresent()) {
                        System.out.println("Found");
                        System.exit(0);
                    }
                }
            }
        System.out.println("None");
    }
}
