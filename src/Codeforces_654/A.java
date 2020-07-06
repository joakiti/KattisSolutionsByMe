package Codeforces_654;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class A {

    static String test = "4\n" +
            "1\n" +
            "2\n" +
            "3\n" +
            "4";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        while (n-- != 0) {
            int noPieces = s.nextInt();
            System.out.println((noPieces + 1)/2);
        }
    }
}
