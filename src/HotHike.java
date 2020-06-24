import java.util.Scanner;

public class HotHike {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        int day = 0;
        int[] temperatures = new int[n];
        for (int i = 0; i < n; i++) {
            temperatures[i] = s.nextInt();
        }
        int temp = Math.max(temperatures[0], temperatures[2]);
        for (int i = 1; i < n; i++) {
            if (i < n - 2) {
                int max = Math.max(temperatures[i], temperatures[i + 2]);
                if (temp > max) {
                    day = i;
                    temp = max;
                }
            }
        }
        System.out.printf("%d %d", day + 1, temp);


    }
}
