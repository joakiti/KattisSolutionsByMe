import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class LostLineup {

    static String test = "4\n" +
            "1 2 0";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int t = s.nextInt() - 1;
        ArrayList<Person> line = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            line.add(new Person(i + 2, s.nextInt()));
        }
        line.sort(Comparator.comparingInt(o -> o.number));
        System.out.print(1 + " ");
        for (Person person:
             line) {
            System.out.print(person.id + " ");
        }

    }

    static class Person {
        int id;
        int number;
        Person(int id, int number) {
            this.id = id;
            this.number = number;
        }
    }
}
