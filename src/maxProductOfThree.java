import java.util.Arrays;

class MaxProductOfThree {

    public static void main(String[] args) {
        System.out.println(maximumProduct(new int[]{-1, -2, -3}));
    }

    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int last = nums[nums.length - 1];
        int nextLast = nums[nums.length - 2];
        int thirdLast = nums[nums.length - 3];

        int first = nums[0];
        int second = nums[1];

        return Integer.max(last * nextLast * thirdLast, first * second * last);
    }
}