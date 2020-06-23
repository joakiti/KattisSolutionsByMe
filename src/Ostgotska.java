import java.util.Scanner;

public class Ostgotska {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] words = s.nextLine().split(" ");

        int occurences = 0;
        for (String w :
                words) {
            if (w.contains("ae")) {
                occurences++;
            }
        }
        double percentage = occurences / (double) words.length;
        if (percentage * 100 >= 40) {
            System.out.println("dae ae ju traeligt va\n");
        } else {
            System.out.println("haer talar vi rikssvenska\n");
        }
    }
}
