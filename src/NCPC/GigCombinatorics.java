package NCPC;

import java.util.Scanner;

public class GigCombinatorics {

    static String test = "28\n" +
            "1 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 3";



    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long combinations = 0;
        int ones = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int next = s.nextInt();
            if (next == 1) {
                ones++;
            }
            if (next == 2) {
                combinations *= 2;
                combinations += ones;
            }
            if (next == 3) {
                sum += combinations;
            }
            int mod = 1000000007;
            while (sum > mod) {
                sum -= mod;
            }
            while (combinations > mod) {
                combinations -= mod;
            }
        }
        System.out.println(sum);
    }
}
