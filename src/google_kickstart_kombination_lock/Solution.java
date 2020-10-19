package google_kickstart_kombination_lock;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    static String test = "2\n" +
            "3 1000000000\n" +
            "1 500000000 1000000000\n" +
            "4 10\n" +
            "2 9 3 8";

    public static void main(String[] args) {
        Scanner s = new Scanner(test);
        Solution ks = new Solution();
        int tests = s.nextInt();
        for (int i = 1; i <= tests; i++) {
            int w = s.nextInt(); //This is initial values
            int n = s.nextInt(); //This is possible values that can be taken on
            int[] matrix = new int[w];
            for (int j = 0; j < w; j++) {
                matrix[j] = s.nextInt();
            }
            System.out.println(String.format("Case #%d: %s", i, new Solution().minMoveCombationLock(matrix, n)));
        }
    }

    public long minMoveCombationLock(int[] initialValues, int n) {
        int min = Integer.MAX_VALUE;
        for (Integer toGo : initialValues) {
            int location = initialValues[0];
            int distanceGoingOneWay = (n - (location - toGo)) % n;
            int distanceGoingRight = (n + (location - toGo)) % n;
            int sum = Math.min(distanceGoingOneWay, distanceGoingRight);
            for (int j = 1; j < initialValues.length; j++) {
                int locationJ = initialValues[j];
                int distanceGoingOneWayJ = (n - (locationJ - toGo)) % n;
                int distanceGoingRightJ = (n + (locationJ - toGo)) % n;
                sum += Math.min(distanceGoingOneWayJ, distanceGoingRightJ);
            }
            min = Math.min(min, sum);
        }
        return min;
    }
}
