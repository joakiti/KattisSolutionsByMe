package Codeforces_654;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class E {

    static String test = "";

    public static void main(String[] args) {
        Scanner s = new Scanner(test);

        int n = s.nextInt();
        while (n-- != 0) {

        }
    }
    public int bagOfTokensScore(int[] tokens, int P) {
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();
        for (Integer t : tokens) {
            max.add(t);
            min.add(t);
        }
        int score = 0;
        while (max.size() > 0 && min.size() > 0) {
            if (P <= min.peek()) {
                score++;
                int remove = min.poll();
                max.remove(remove);
            }
            else if (score > 0) {
                int addAndRemove = max.poll();
                min.remove(addAndRemove);
            }
            else {
                return score;
            }
        }
        return score;
    }


}
