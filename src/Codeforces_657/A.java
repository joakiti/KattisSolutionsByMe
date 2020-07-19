package Codeforces_657;

import java.util.Scanner;

public class A {

    static String test = "6\n" +
            "7\n" +
            "abacaba\n" +
            "7\n" +
            "???????\n" +
            "11\n" +
            "aba?abacaba\n" +
            "11\n" +
            "abacaba?aba\n" +
            "15\n" +
            "asdf???f???qwer\n" +
            "11\n" +
            "abacabacaba";

    static String GOAL = "abacaba";
    static char[] GOAL_CHARS = "abacaba".toCharArray();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        while (n-- != 0) {
            int length = s.nextInt();
            String str = s.next();
            char[] chars = str.toCharArray();
            for (int i = 0; i < str.length(); i++) {
                if (chars[i] == 'a' || chars[i] == '?')  {
                    i = win(str, chars, i);
                    if (i == str.length()) {
                        continue;
                    }
                    for (int j = i; j < Math.min(i + GOAL.length(), str.length()); j++) {
                        if (chars[j] != GOAL_CHARS[j - i]) {
                            if (chars[j] == '?') {
                                chars[j] = GOAL_CHARS[j - i];
                            }
                            else {
                                break;
                            }
                        }
                    }
                    i = win(str, chars, i);
                    chars = str.toCharArray();
                }
                if (i == str.length() - 1) {
                    System.out.println("No");
                }
            }
        }
    }

    private static int win(String str, char[] chars, int i) {
        if (containsTheGoal(String.valueOf(chars))) {
            System.out.println("Yes");
            for (char c:
                  chars) {
               if (c == '?') {
                   System.out.printf("z");
               }
               else {
                   System.out.printf("%c",c);
               }
            }
            System.out.printf("\n");
            i = str.length();
        }
        return i;
    }

    static  boolean containsTheGoal(String str) {
        return str.contains(GOAL) && str.indexOf(GOAL) == str.lastIndexOf(GOAL);
    }
}
