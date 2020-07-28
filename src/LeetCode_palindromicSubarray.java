import java.util.HashMap;

public class LeetCode_palindromicSubarray {

    public int minimumMoves(int[] arr) {
        int maximalPalindromeLength = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    maximalPalindromeLength = Math.max(arr[j] - arr[i], maximalPalindromeLength);
                }
            }
        }
        return 1;
    }
}
