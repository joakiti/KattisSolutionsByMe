package google_kickStart_mergeCards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static String test = "2\n" +
            "3\n" +
            "2 1 10\n" +
            "5\n" +
            "19 3 78 2 31";

    public static void main(String[] args) {
        Scanner s = new Scanner(test);
        Solution ks = new Solution();
        int tests = s.nextInt();
        for (int i = 1; i <= tests; i++) {
            int n = s.nextInt(); //This is possible values that can be taken on
            int[] matrix = new int[n];
            for (int j = 0; j < n; j++) {
                matrix[j] = s.nextInt();
            }
            System.out.println(String.format("Case #%d: %s", i, new Solution().mergeCards(matrix)));
        }
    }

    public double mergeCards(int[] initialValues) {
        double answer = 0;
        int n = initialValues.length;
        for(int x = 0; x < n - 1; ++x) {
            for(int i = x; i >= 0; --i) {
                answer += initialValues[i] / (double) (x - i + 1);
            }
            for(int i = x + 1; i < n; ++i) {
                answer += initialValues[i] / (double) (i - x);
            }
        }
        return answer;
    }
}
