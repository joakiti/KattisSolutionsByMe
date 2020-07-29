import java.util.Arrays;

public class LeetCode_SortArrayByParity {
    public static void main(String[] args) {
        int[] test = new int[]{3, 1, 0};
        System.out.println(Arrays.toString(sortArrayByParity(test)));
    }

    public static int[] sortArrayByParity(int[] A) {
        if (A.length < 2) {
            return A;
        }
        int oddPointer = findFirstOdd(0, A);
        int evenPointer = findFirstEven(A.length - 1, A);

        while(oddPointer < evenPointer && oddPointer != -1 && evenPointer != -1) {
            int temp = A[oddPointer];
            A[oddPointer] = A[evenPointer];
            A[evenPointer] = temp;
            oddPointer = findFirstOdd(oddPointer + 1, A);
            evenPointer = findFirstEven(evenPointer - 1, A);
        }
        return A;

    }
    static int findFirstOdd(int from, int[] A) {
        for (int i = from; i < A.length; i++) {
            if (A[i] % 2 == 1) {
                return i;
            }
        }
        return -1;
    }

    static int findFirstEven(int from, int[] A) {
        for (int i = from; i >= 0; i--) {
            if (A[i] % 2 == 0) {
                return i;
            }
        }
        return -1;
    }
}
