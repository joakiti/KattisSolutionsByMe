package adv_algorithms.experiments;

import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;

public class QuadraticTableLookupFourSum {
    static String test = "5\n" +
            "4\n" +
            "-3\n" +
            "2\n" +
            "1\n" +
            "-7";

    public static void main(String[] args) {
        HashMap<Long, HashMap<Long, Integer>> H = new HashMap<>();
        HashMap<Long, Integer> H2 = new HashMap<>();

        Scanner S = new Scanner(test);

        int N = Integer.parseInt(S.nextLine());
        long[] vals = new long[N];
        for (int i = 0; i < N; i += 1) {
            vals[i] = Long.parseLong(S.nextLine());
            H2.put(vals[i], i);
        }
        for (int i = 0; i < N; i++) {
            H.putIfAbsent(vals[i], new HashMap<>());
            for (int j = 0; j < N; j++) {
                final long key = -vals[i] - vals[j];
                H.get(vals[i]).put(key, H2.get(key));
            }
        }

        // the variables are ordered l < k < j < i; sorry
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < i; j += 1) {// i goes through {0, ..., N-1}
                Integer a = H.get(vals[i]).get(-vals[i] - vals[j]);

                if (a != null && i < a) {
                    System.out.println("Found");
                }
            }
        System.out.println("None");
    }
}
