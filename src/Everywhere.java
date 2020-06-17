import java.util.HashSet;
import java.util.Scanner;

public class Everywhere {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        while (n-- != 0) {
            int cities = s.nextInt();
            HashSet<String> citiesVisited = new HashSet<>();
            while (cities-- != 0) {
                citiesVisited.add(s.next());
            }
            System.out.println(citiesVisited.size());
        }
    }
}
