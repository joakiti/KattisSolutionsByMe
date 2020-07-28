import java.util.Arrays;

public class LeetCode_DuplicateZeros {

    public void duplicateZeros(int[] arr) {
        int zeroCount = 0;
        int indexLength = arr.length - 1;

        for (int i = 0; i <= indexLength - zeroCount; i++) {
            if (arr[i] == 0) {
                if (i == indexLength - zeroCount) {
                    arr[indexLength] = 0;
                    indexLength--;
                    break;
                }
                zeroCount++;
            }
        }

        int elementsToBeDeleted = zeroCount;
        for (int i = indexLength - elementsToBeDeleted; i >= 0; i--) {
            if (arr[i] == 0) {
                //copy twice
                arr[i + elementsToBeDeleted] = arr[i];
                elementsToBeDeleted--;
                arr[i + elementsToBeDeleted] = arr[i];
            } else {
                arr[i + elementsToBeDeleted] = arr[i];
            }
        }
    }

}
