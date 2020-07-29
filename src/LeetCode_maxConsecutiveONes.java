public class LeetCode_maxConsecutiveONes {

    public static void main(String[] args) {
        int[] test = new int[]{1, 0, 1, 0, 0, 0, 1};
        System.out.println(findMaxConsecutiveOnes(test));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int nonFlipCount = 0, flipCount = 0, max = 0;
        for (int num : nums) {
            if (num == 1) {
                nonFlipCount++;
                flipCount++;
            } else {
                flipCount = nonFlipCount + 1;
                nonFlipCount = 0;
            }
            max = Math.max(max, flipCount);
        }
        return max;
    }
}
