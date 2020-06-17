import java.util.Scanner;

public class TripleTexting {

    static String test = "hellohrllohello\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String grandmasText = s.next();

        int lengthOfWord = grandmasText.length()/3;

        String word1 = grandmasText.substring(0, lengthOfWord);
        String word2 = grandmasText.substring(lengthOfWord, 2*lengthOfWord);
        String word3 = grandmasText.substring(2*lengthOfWord, 3*lengthOfWord);
        if (word1.equals(word2)) {
            System.out.println(word1);
        }
        else if (word1.equals(word3)) {
            System.out.println(word1);
        }
        else {
            System.out.println(word2);
        }
    }
}
