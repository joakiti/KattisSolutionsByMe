import java.util.Arrays;
import java.util.Scanner;

public class OddGnome {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int groups = s.nextInt();

        while (groups-- != 0) {
            int gnomes = s.nextInt();
            int[] gnome = new int[gnomes];
            for (int i = 0; i < gnomes; i++) {
                gnome[i] = s.nextInt();
            }
            int lower = 1;
            int higher = gnomes - 2;
            int ans = -1;
            while (lower<= higher) {
                int mid = lower + (higher-lower)/2;
                int value = gnome[mid];
                if (mid != value - gnome[0]) {
                    ans = mid;
                    higher = mid - 1;
                }
                else {
                    lower = mid + 1;
                }
            }
            System.out.println(ans + 1);
        }
    }
}
