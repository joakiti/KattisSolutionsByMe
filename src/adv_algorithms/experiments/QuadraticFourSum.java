package adv_algorithms.experiments;

import java.util.Scanner;

public class QuadraticFourSum {

    static String test = "5\n" +
                            "4\n" +
            "3\n" +
            "2\n" +
            "1\n" +
            "-7";

    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        int N = Integer.parseInt(S.nextLine());
        long[] vals = new long[N];
        for (int i = 0; i < N; i += 1) vals[i] = Long.parseLong(S.nextLine());
        for (int i = 0; i < N; i += 1) // i goes through {0, ..., N-1}
            for (int j = i + 1; j < N; ++j)
                for (int k = j + 1; k < N; ++k)
                    for (int l = k + 1; l < N; l++) {
                        if (vals[i] + vals[j] + vals[k] + vals[l] == 0) {
                            System.out.println("Found");
                            System.exit(0);
                        }
                    }
        System.out.println("None");
    }
}

