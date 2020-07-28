import java.util.Arrays;

public class LeetCode_ifExistsDuplicate {

    public static void main(String[] args) {
        int[] test = new int[]{-2,0,10,-19,4,6,-8};
        System.out.println(checkIfExist(test));
    }

    public static boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int indexOfVal = binarySearch(arr, arr[i]*2);
            if (indexOfVal != i && indexOfVal != -1) {
                return true;
            }
        }
        return false;
    }

     static int binarySearch(int[] arr, int target) {
        int top = arr.length - 1;
        int bottom = 0;
        while (top >= bottom) {
            int mid = bottom + (top-bottom)/2;
            if (arr[mid] == target) {
                System.out.printf("mid: %d, midval: %d,  target: %d\n", mid, arr[mid], target);
                return mid;
            }
            if (arr[mid] > target) {
                top = mid - 1;
            }
            else {
                bottom = mid + 1;
            }
        }
        return -1;
    }
}
