package Codeforces_657;

import java.util.Scanner;

public class B {

    static String test = "2\n" +
            "500000 500000 10000000000\n\n" +
            "2 3 1\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int tests = s.nextInt();
        continueTest:
        while (tests-- != 0) {
            //m = n*a + b-c goal is N
            long l = s.nextLong();
            long r = s.nextLong();
            long m = s.nextLong();

            /**
             * This is the bottleneck of the application. Should have been optimized to consider the earliest
             * values where n could possible be a solution.
             */
            for (int n = 1; n < Integer.MAX_VALUE; n++) {
                long bottom = l;
                long top = r;
                long a = -1;
                while (bottom <= top) {
                    long mid = bottom + (top - bottom) / 2;
                    if (mid*n >= m - l && mid*n <= m + r) {
                        a = mid;
                        break;
                    }
                    else if (mid * n < m - l){
                        bottom = mid + 1;
                    }
                    else {
                        top = mid - 1;
                    }
                }
                if (a == -1) continue;
                double diff = m - (a * n);
                if (Math.abs(diff) <= r - l) {
                    if (diff < 0) {
                        long b = l;
                        long c = l + (long) Math.abs(diff);
                        System.out.printf("%d %d %d\n", a, b, c);
                        continue continueTest;
                    } else if (diff > 0) {
                        long b = l + (long) Math.abs(diff);
                        long c = l;
                        System.out.printf("%d %d %d\n", a, b, c);
                        continue continueTest;
                    }
                }

            }
        }

    }
}
