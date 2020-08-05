package google_kickstart_roundA2020;

import java.util.Scanner;
import java.util.Arrays;

public class A {

    static String test = "3\n" +
            "4 100\n" +
            "20 90 40 90\n" +
            "4 50\n" +
            "30 30 10 10\n" +
            "3 300\n" +
            "999 999 999";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int test = s.nextInt();
        int testCount = 0;

        while (testCount++ < test) {
            int N = s.nextInt();
            int money = s.nextInt();
            int[] cost = new int[N];
            for (int i = 0; i < N; i++) {
                cost[i] = s.nextInt();
            }
            Arrays.sort(cost);
            int purchases = 0;
            while (purchases < cost.length && cost[purchases] <= money) {
                money -= cost[purchases];
                purchases++;
            }
            System.out.printf("Case #%d: %d\n", testCount, purchases);
        }
    }
}
