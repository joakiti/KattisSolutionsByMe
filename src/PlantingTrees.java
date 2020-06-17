import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class PlantingTrees {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int seeds = s.nextInt();
        Integer[] growTimes = new Integer[seeds];
        for (int i = 0; i < growTimes.length; i++ ) {
            growTimes[i] = s.nextInt();
        }
        Arrays.sort(growTimes, Collections.reverseOrder());
        int days = 1;
        int high = 0;
        for (int i = 0; i < seeds; i++) {
            if (days + growTimes[i] > high) {
                high = days+growTimes[i];
            }
            days++;
        }
        high++;
        System.out.println(high);
    }
}
