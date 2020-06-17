import java.util.Scanner;

public class JanitorTroubles {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();
        int d = s.nextInt();

        double semi = (a+b+c+d)/(double) 2;
//Brahmagupta's formula
        double k = Math.sqrt((semi-a)*(semi-b)*(semi-c)*(semi-d));
        System.out.println(k);

    }
}
