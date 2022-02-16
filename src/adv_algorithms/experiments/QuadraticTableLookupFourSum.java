package adv_algorithms.experiments;

import java.util.*;
import java.util.stream.Collectors;

public class QuadraticTableLookupFourSum {

    public static void main(String[] args) {
        HashMap<Long, HashMap<Integer, ArrayList<Integer>>> H2 = new HashMap<>();

        Scanner S = new Scanner(System.in);

        int N = Integer.parseInt(S.nextLine());
        long[] vals = new long[N];
        for (int i = 0; i < N; i += 1) {
            vals[i] = Long.parseLong(S.nextLine());
        }
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                H2.putIfAbsent(vals[i] + vals[j], new HashMap<>());
                H2.get(vals[i] + vals[j]).putIfAbsent(j, new ArrayList<>());
                H2.get(vals[i] + vals[j]).get(j).add(i);
            }
        }
        // the variables are ordered l < k < j < i; sorry
        for (int i = 0; i < N; ++i)
            for (int j = i + 1; j < N; j += 1) {// i goes through {0, ..., N-1}
                long key = vals[i] + vals[j];
                var solutionKey = H2.get(-key);
                if (solutionKey != null) {
                    checkIfUniqueSolution(i, j, solutionKey);
                }
            }
        System.out.println("None");
    }

    private static void checkIfUniqueSolution(int i, int j, HashMap<Integer, ArrayList<Integer>> solutionKey) {
        for (Map.Entry<Integer, ArrayList<Integer>> values : solutionKey.entrySet()) {
            if (values.getKey() != i && values.getKey() != j) {
                for (Integer possibleMatch : values.getValue()) {
                    if (possibleMatch != i && possibleMatch != j) {
                        System.out.println("Found");
                        System.exit(0);
                    }
                }
            }
        }
    }
}
