import java.util.Arrays;

public class LeetCode_removeDuplicates {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.removeDuplicates(new int[]{1,1,2})));
    }

    static class Solution {
        public int[] removeDuplicates(int[] nums) {
            int indexNewArray = 0;
            int length = nums.length - 1;
            int i = 0;
            while (indexNewArray <= length && i < nums.length) {
                while (i != length && nums[i] == nums[i+1]) {
                    i++;
                }
                nums[indexNewArray] = nums[i];
                i++;
                indexNewArray++;
            }
            return nums;
        }
    }
}
