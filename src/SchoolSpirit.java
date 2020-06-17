import java.util.Scanner;

public class SchoolSpirit {

    static String test = "3\n" +
            "500\n" +
            "120\n" +
            "75";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] studentScores = new int[n];

        for (int i = 0; i < n; i++) {
            studentScores[i] = s.nextInt();
        }
        double score = kattisScore(studentScores, Integer.MAX_VALUE);
        System.out.println(score);
        double totalScoreIfLeaving = 0.;
        for (int i = 0; i < n; i++) {
            totalScoreIfLeaving += kattisScore(studentScores, i);
        }
        System.out.println(totalScoreIfLeaving/n);
    }

    static double kattisScore(int[] scores, int adjustment) {
        double total = 0;
        for (int i = 0; i < scores.length; i++) {
            if (i == adjustment) {
                continue;
            }
            if (i > adjustment) {
                total += scores[i] * Math.pow(4/5., i-1);
                continue;
            }
            total += scores[i] * Math.pow(4/5., i);
        }
        return total * 1/5.;
    }
}
