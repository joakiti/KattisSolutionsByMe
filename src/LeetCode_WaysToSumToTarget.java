import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class LeetCode_WaysToSumToTarget {

    public static void main(String[] args) {
        for (List<Integer> list : combinationSum(new int[]{2,3, }, 5)) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            combinationSumSorted(candidates, i, target - candidates[i], List.of(candidates[i]), ans);
        }
        return ans;
    }

    public static void combinationSumSorted(int[] candidates, int start, int target, List<Integer> curr, List<List<Integer>> ans) {
        for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
            ArrayList<Integer> newCurr = new ArrayList<>(curr);
            newCurr.add(candidates[i]);
            combinationSumSorted(candidates, i, target - candidates[i], newCurr, ans);
        }
        if (target == 0) {
            ans.add(curr);
        }
    }
}
