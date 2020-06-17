import java.util.Scanner;

public class Apaxiaaaaaaaaaaaans {

    static String test = "roooooobertapalaxxxxios";
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String name = s.next();

        StringBuilder sb = new StringBuilder();
        char lastC = 0;
        for (char c :
                name.toCharArray()) {
            if (lastC != c) {
                lastC = c;
                sb.append(c);
            }
        }

        System.out.println(sb.toString());

    }
}
