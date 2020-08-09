import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LeetCode_findDuplicates {


    public static void main(String[] args) {
        //int[] test = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        //var a = findDuplicates(test);
        //System.out.println(a);

        var root = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5, null, null)))));
        System.out.println(pathSum(root, 3));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
        }
        HashSet<Integer> solution = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                solution.add(Math.abs(nums[i]));
            }
        }
        return new ArrayList<>(solution);
    }

    static int count = 0;
    static int target;
    static HashMap<Integer, Integer> h = new HashMap();

    public static void preorder(TreeNode node, int currSum) {
        if (node == null)
            return;

        currSum += node.val;

        if (currSum == target)
            count++;

        // number of times the curr_sum − k has occured already,
        // determines the number of times a path with sum k
        // has occured upto the current node
        count += h.getOrDefault(currSum - target, 0);

        // add the current sum into hashmap
        // to use it during the child nodes processing
        h.put(currSum, h.getOrDefault(currSum, 0) + 1);

        // process left subtree
        preorder(node.left, currSum);
        // process right subtree
        preorder(node.right, currSum);

        // remove the current sum from the hashmap
        // in order not to use it during
        // the parallel subtree processing
        h.put(currSum, h.get(currSum) - 1);
    }

    public static int pathSum(TreeNode root, int sum) {
        target = sum;
        preorder(root, 0);
        return count;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
