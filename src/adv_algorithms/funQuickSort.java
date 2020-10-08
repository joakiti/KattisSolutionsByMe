package adv_algorithms;

import java.util.ArrayList;
import java.util.Random;

public class funQuickSort {

    static int comparisons;
    static int[][] events;

    public static void main(String[] args) {
        int size = 100;
        for (int j = 1; j < size; j++) {
            int comparsonSum = 0;
            for (int iterations = 0; iterations < 10; iterations++) {
                comparisons = 0;
                Random r = new Random();
                ArrayList<Integer> vals = new ArrayList<>();
                events = new int[size][size];
                for (int i = 0; i < j; i++) {
                    vals.add(r.nextInt(size*2));
                }
                quickSort(vals);
                comparsonSum += comparisons;
            }
            System.out.println(comparsonSum/10);
        }
    }

    private static ArrayList<Integer> quickSort(ArrayList<Integer> vals) {
        if (vals.size() <= 1) {
            return vals;
        }
        Random r = new Random();
        int pivot = vals.get(r.nextInt(vals.size()));
        ArrayList<Integer> valsSmaller = new ArrayList<>();
        ArrayList<Integer> valsGreater = new ArrayList<>();
        ArrayList<Integer> finalValsSmaller = valsSmaller;
        ArrayList<Integer> finalValsGreater = valsGreater;
        vals.forEach(p -> {
            if (p < pivot) {
                finalValsSmaller.add(p);
                comparisons++;
            }
            if (p > pivot) {
                finalValsGreater.add(p);
                comparisons++;
            }
        });
        valsSmaller = quickSort(finalValsSmaller);
        valsGreater = quickSort(finalValsGreater);
        ArrayList<Integer> returnValue = new ArrayList<>(valsSmaller);
        returnValue.add(pivot);
        returnValue.addAll(valsGreater);
        return returnValue;

    }
}
