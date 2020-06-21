import java.util.Scanner;

public class HeirsDilemma {
    static String test = "200000 300000\n";
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int bottom = s.nextInt();
        int higher = s.nextInt();
        int answer = 0;
        for (int i = bottom; i <= higher; i++) {
            if (possible(i)) {
                answer++;
            }

        }
        System.out.println(answer);
    }

    public static boolean possible(int combo) {
        return different(combo) && divisible(combo);
    }

    public static boolean different(int n) {
        String s = Integer.toString(n);
        for (int i = 0; i <= 9; i++)
            if(s.indexOf(String.valueOf(i)) != s.lastIndexOf(String.valueOf(i)))
                return false;
        return true;
    }

    public static boolean divisible(int combo) {
        String s = Integer.toString(combo);
        for (int i = 0; i < s.length(); i++) {
            int digit = Integer.parseInt(s.substring(i, i + 1));
            if (digit == 0 || combo % digit != 0) {
                return false;
            }
        }
        return true;
    }
}