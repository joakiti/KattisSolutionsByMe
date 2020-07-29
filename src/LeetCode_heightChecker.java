import java.util.Arrays;

public class LeetCode_heightChecker {

    public static void main(String[] args) {
        System.out.println(heightChecker(new int[]{1,1,4,2,1,3}));
    }

        public static int heightChecker(int[] heights) {
            int[] originals = new int[heights.length];
            System.arraycopy(heights, 0, originals, 0, heights.length);
            for (int i = 1; i < heights.length; ++i) { // O(N)
                int X = heights[i]; // X is the item to be inserted
                int j = i-1;
                for (; j >= 0 && heights[j] > X; --j) // can be fast or slow
                    heights[j+1] = heights[j]; // make a place for X
                heights[j+1] = X; // index j+1 is the insertion point
            }
            int ans = 0;
            for (int i = 0; i < originals.length; i++) {
                if (originals[i] != heights[i]) {
                    ans++;
                }
            }
            return ans;
        }
}
