import java.util.HashMap;

class MergeLinkedList {

    public static int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0, maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == k) maxLen = i + 1;

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

            if (map.containsKey(sum - k)) {
                if (maxLen < (i - map.get(sum - k)))
                    maxLen = i - map.get(sum - k);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArrayLen(new int[]{4,5,1,}, 6));
    }
}