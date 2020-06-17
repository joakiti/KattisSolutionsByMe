import java.util.Scanner;

public class DetailedDifferences {

    public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            int cases = Integer.parseInt(s.nextLine());
            for (int i = 0; i < cases; i++) {
                StringBuilder sb = new StringBuilder();
                char[] first = s.nextLine().toCharArray();
                char[] second = s.nextLine().toCharArray();
                for (int j = 0; j < first.length; j++) {
                    if (first[j] == second[j]) {
                        sb.append('.');
                    }
                    else sb.append('*');
                }
                System.out.println(new String(first));
                System.out.println(new String(second));
                System.out.println(sb.toString());
                System.out.println();
            }
        }
}
