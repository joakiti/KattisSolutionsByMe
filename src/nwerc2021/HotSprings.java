package nwerc2021;

import java.util.ArrayList;
import java.util.Scanner;

public class HotSprings {

    String testInput = "3\n" +
            "1 3 4\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        ArrayList<Integer> input = new ArrayList<>();
        while (n--> 0) {
            input.add(s.nextInt());
        }

        ArrayList<ArrayList<Integer>> tuples = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            tuples.add(i, new ArrayList<>());
            for (int j = i + 1; j < input.size(); j++) {
                tuples.get(i).add(j);
            }
        }


    }
}
