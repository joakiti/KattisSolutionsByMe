package google_kickstart_roundA2020;

import java.util.Arrays;
import java.util.Scanner;

public class B {

    static String test = "2\n" +
            "2 4 5\n" +
            "10 10 100 30\n" +
            "80 50 10 50\n" +
            "3 2 3\n" +
            "80 80\n" +
            "15 50\n" +
            "20 10";


    public static void main(String[] args) {
        Scanner s = new Scanner(test);

        int test = s.nextInt();
        int testCount = 0;

        while (testCount++ < test) {
            int N = s.nextInt();
            int K = s.nextInt();
            int P = s.nextInt();
            int[][] dp = new int[N + 1][P + 1];
            //dp(i)(j) is maximum stack that can be
            //obtained using i stacks when we can pick j plates in total.
            int[][] plates = new int[N + 1][K + 1];
            for (int i = 1; i < N; i++) {
                plates[i][1] = s.nextInt();
                for (int j = 1; j < K; j++) {
                    plates[i][j+1] = plates[i][j] + s.nextInt();
                }
            }

            for (int fromNStack = 0; fromNStack <= N; fromNStack++) {

            }

            System.out.printf("Case #%d: %d\n", testCount, dp[N][P]);
        }
    }
}
