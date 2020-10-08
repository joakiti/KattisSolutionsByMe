import java.util.Arrays;

public class leetcode_MaximumNonNegativeProduct {

    public static void main(String[] args) {

    }

    public static long maxProductPath(int[][] grid) {
        long[][][] dp = new long[grid.length][grid[0].length][2];
        if (grid[0][0] < 0) {
            dp[0][0][0] = grid[0][0];
        } else {
            dp[0][0][1] = grid[0][0];
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int iAdjusted = i == 0 ? 1 : i;
                int jAdjusted = j == 0 ? 1 : j;

                long maxNegative;
                long maxPositive;
                if (grid[i][j] < 0) {
                    maxNegative = Math.min(
                            dp[iAdjusted - 1][j][1] * grid[i][j],
                            dp[i][jAdjusted - 1][1] * grid[i][j]
                    );
                    maxPositive = Math.max(
                            dp[iAdjusted - 1][j][0] * grid[i][j],
                            dp[i][jAdjusted - 1][0] * grid[i][j]
                    );
                }
                else {
                    maxNegative = Math.min(
                            dp[iAdjusted - 1][j][0] * grid[i][j],
                            dp[i][jAdjusted - 1][0] * grid[i][j]
                    );
                    maxPositive = Math.max(
                            dp[iAdjusted - 1][j][1] * grid[i][j],
                            dp[i][jAdjusted - 1][1] * grid[i][j]
                    );
                }
                dp[i][j][0] = maxNegative;
                dp[i][j][1] = maxPositive;
            }
        }
        long max = Math.max(dp[grid.length - 1][grid[0].length - 1][0], dp[grid.length - 1][grid[0].length - 1][1]);
        if (max == 0) {
            for (int[] longs : grid) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (longs[j] == 0) {
                        return 0;
                    }
                }
            }
            return -1;
        }
        if (max < 0) {
            return -1;
        }
        return max % 1_000_000_007;
    }
}
