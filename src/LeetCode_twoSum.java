import java.time.Duration;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class LeetCode_twoSum {

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
        //System.out.println(thirdMax(new int[]{2,2,3,1}));
        //System.out.println(findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
        //System.out.println(isPalindrome("aa"));
        //System.out.println(isPowerOfFour(3));
        int[] test = new int[]{2,1,3,5,4,6,7};
        int k = 2;
        //System.out.println(getWinner(test, k));
        System.out.println(customSortString("cba", "abcd"));
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indexMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int secondIndex = target - nums[i];
            if (indexMap.containsKey(secondIndex) && indexMap.get(secondIndex) != i) {
                return new int[]{i, indexMap.get(secondIndex)};
            }
        }
        return new int[]{};
    }

    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        Integer[] filteredNums = Arrays.stream(nums).distinct().boxed().toArray(Integer[]::new);
        if (filteredNums.length < 3) return filteredNums[filteredNums.length - 1];
        return filteredNums[filteredNums.length - 3];
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);
            nums[val - 1] = -Math.abs(nums[val - 1]);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    public static boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        s = s.replaceAll("[^a-zA-Z]", "").toLowerCase();
        if (s.length() == 0) return true;
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPowerOfFour(int num) {
        int mFF = 0xFF;
        int mFFFF = (mFF << 8) + mFF;
        int mFFFFFFFF = (mFFFF << 16) + mFFFF;
        boolean isXZero = (0 == (num & mFFFFFFFF));
        boolean isXNegative = ((num >> 31) & 1) == 1;
        int powerOfFourMask = 0x55555555;
        int hit = (num & powerOfFourMask);
        if (hit == 0 || isXZero || isXNegative) {
            return false;
        }
        return 0 == (num & (num - 1));
    }
    public int minSwaps(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        return 1;
    }
    public int daysBetweenDates(String date1, String date2) {
        LocalDate date1Time = LocalDate.parse(date1);
        LocalDate date2Time = LocalDate.parse(date2);
        return (int) Duration.between(date1Time.atStartOfDay(), date2Time.atStartOfDay()).toDays();
    }

    public static String customSortString(String S, String T) {
        int[] values = new int[200];
        for (int i = 0, j = S.length() - 1; i < S.length(); i++, j--) {
            values[S.charAt(i)] = i;
        }
        List<Integer> sortedByS = T.chars().boxed().sorted(Comparator.comparingInt(o -> values[o])).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for (Integer i : sortedByS) {
            sb.append((char) i.intValue());
        }
        return sb.toString();
    }


    public static int getWinner(int[] arr, int k) {
        int[] valsSorted = new int[arr.length];
        System.arraycopy(arr, 0, valsSorted, 0, arr.length);
        Arrays.sort(valsSorted);
        int candidate = arr[0];
        int hasWonOneBattle = 0;
        while (true) {
            int beatenBy = binarySearch(valsSorted, candidate);
            if (beatenBy == - 1) {
                return candidate;
            }
            else {
                int i = 1;
                while (i < arr.length && arr[i] < beatenBy) {
                    i++;
                }
                int beaten = i - 1 + hasWonOneBattle;
                if (beaten == arr.length - 1 || beaten >= k) {
                    return candidate;
                } else {
                    int nextCandidate = arr[i];
                    int[] tempArray = new int[arr.length];
                    tempArray[0] = nextCandidate;
                    tempArray[arr.length - 1] = candidate;
                    System.arraycopy(arr, i + 1, tempArray, 1, arr.length - (i + 1));
                    System.arraycopy(arr, 1, tempArray, arr.length - (i + 1) + 1, beaten);
                    hasWonOneBattle = 1;
                    arr = tempArray;
                    candidate = nextCandidate;

                }
            }
        }
    }

    public static int binarySearch(int[] valsSorted, int target) {
        int bottom = 0;
        int top = valsSorted.length - 1;
        target += 1;
        int greatestValue = -1;
        while (top >= bottom) {
            int mid = bottom + (top-bottom)/2;
            if (valsSorted[mid] >= target) {
                greatestValue = valsSorted[mid];
                top = mid -1;
            }
            else {
                bottom = mid + 1;
            }
        }
        return greatestValue;
    }

}
