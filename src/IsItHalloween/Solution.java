package IsItHalloween;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    static String test = "2\n" +
            "3\n" +
            "1 2 5\n" +
            "3 6 1\n" +
            "12 2 7\n" +
            "5\n" +
            "0 0 0 0 0\n" +
            "1 1 1 1 0\n" +
            "2 2 2 8 0\n" +
            "1 1 1 0 0\n" +
            "0 0 0 0 0";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Solution ks = new Solution();
        int tests = s.nextInt();
        for (int i = 1; i <= tests; i++) {
            int n = s.nextInt();
            long[][] matrix = new long[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = s.nextInt();
                }
            }
            System.out.println(String.format("Case #%d: %s", i, new Solution().maxCoins(matrix)));
        }
    }

    public long maxCoins(long[][] matrix) {
        long[][] dp = new long[matrix.length][matrix.length];
        for (int i = 0; i < dp.length; i++) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = matrix[i][0];
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                dp[i][j] = dp[i-1][j-1] + matrix[i][j];
            }
        }
        long sum = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                sum = Math.max(sum, dp[i][j]);
            }
        }
        return sum;
    }

}
