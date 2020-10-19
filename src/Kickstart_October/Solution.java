package Kickstart_October;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    static String test = "3\n" +
            "AKICKSTARTPROBLEMNAMEDKICKSTART\n" +
            "STARTUNLUCKYKICK\n" +
            "KICKXKICKXSTARTXKICKXSTART";

    public static void main(String[] args) {
        Scanner s = new Scanner(test);
        IsItHalloween.Solution ks = new IsItHalloween.Solution();
        int tests = s.nextInt();
        for (int i = 1; i <= tests; i++) {
            System.out.println(String.format("Case #%d: %s", i, new Solution().partitionLabels(s.next())));
        }
    }

    public long partitionLabels(String S) {
        ArrayList<Integer> kick = new ArrayList<>();
        ArrayList<Integer> start = new ArrayList<>();
        long sum = 0;
        for (int i = 0; i < S.length() - 3; i++) {
            String substr = S.substring(i, i+4);
            if (substr.equals("KICK")) {
                kick.add(i);
            }
        }
        for (int i = 0; i < S.length() - 4; i++) {
            String substr = S.substring(i, i+5);
            if (substr.equals("START")) {
                start.add(i);
            }
        }
        for (int i = 0; i < kick.size(); i++) {
            int startKick = kick.get(i);
            for (int j = 0; j < start.size(); j++) {
                if (startKick < start.get(j)) {
                    sum += start.size() - j;
                    break;
                }
            }
        }
        return sum;
    }

}
