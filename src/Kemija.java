import java.util.Scanner;

public class Kemija {

    static String test = "zepelepenapa papapripikapa";
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (s.hasNext()) {
            String line = s.next();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                sb.append(c);
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    i += 2;
                }
            }
            System.out.print(sb.toString() + " ");
        }
    }

}
