package Codeforces_654;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class B {

    static String test = "5\n" +
            "3 4\n" +
            "3 2\n" +
            "3 1\n" +
            "13 7\n" +
            "1010000 9999999\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(test);

        int tests = s.nextInt();
        while (tests-- != 0) {
            long n = s.nextInt();
            long r = s.nextInt();
            long ans = 1;
            ans += ((2-r)*(2+r))/2;
            System.out.println(ans);

        }
    }
}
