import java.util.Arrays;

public class LeetCode_mergeSortedArray {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = new int[]{4,5,6,0,0,0};
        int[] nums2 = new int[]{1,5,6};
        solution.merge(nums1, nums1.length, nums2, nums2.length);
        System.out.println(Arrays.toString(nums1));

    }
    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int endPointer = m - 1;
            int nums1Pointer = m - n - 1;
            int nums2Pointer = n - 1;
            while (nums1Pointer >= 0 && nums2Pointer >= 0) {
                if (nums1[nums1Pointer] > nums2[nums2Pointer]) {
                    nums1[endPointer] = nums1[nums1Pointer];
                    nums1Pointer--;
                }
                else {
                    nums1[endPointer] = nums2[nums2Pointer];
                    nums2Pointer--;
                }
                endPointer--;
            }
            System.arraycopy(nums2, 0, nums1, 0, nums2Pointer + 1);
        }
    }
}
