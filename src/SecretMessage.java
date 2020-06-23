import java.util.Scanner;

public class SecretMessage {

    static String test = "2\n" +
            "iloveyouJack\n" +
            "TheContestisOver\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        s.nextLine();
        while (n-- != 0) {
            String plain = s.nextLine();
            int M = (int) Math.ceil(Math.sqrt(plain.length()));
            char[][] encoding = new char[M][M];
            int stringIndex = 0;
            for (int a = 0; a < M; a++) {
                for (int i = 0; i < M; i++) {
                    if (stringIndex >= plain.length()) {
                        encoding[a][i] = '*';
                    } else {
                        encoding[a][i] = plain.charAt(stringIndex);
                        stringIndex++;
                    }
                }
            }
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < M; i++) {
                for (int j = M - 1; j >= 0; j--) {
                    if (encoding[j][i] != '*') {
                        ans.append(encoding[j][i]);
                    }
                }
            }
            System.out.println(ans.toString());
        }
    }
}
