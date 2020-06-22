import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Zoo {

    static String test = "6\n" +
            "African elephant\n" +
            "White tiger\n" +
            "Indian elephant\n" +
            "Siberian tiger\n" +
            "Tiger\n" +
            "Panda bear\n" +
            "1\n" +
            "Blue Russian Penguin\n" +
            "0\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int list = 1;

        while (true) {
            int n = s.nextInt();
            s.nextLine();
            if (n == 0) {
                System.exit(0);
            }
            TreeMap<String, Integer> animalCount = new TreeMap<>();
            while (n-- != 0) {
                String[] animal = s.nextLine().split(" ");
                String generalSpecies = animal[animal.length - 1].toLowerCase();
                animalCount.put(generalSpecies, animalCount.getOrDefault(generalSpecies, 0) + 1);
            }
            System.out.printf("List %d:\n", list);
            for (Map.Entry<String, Integer> animal : animalCount.entrySet()) {
                System.out.println(animal.getKey() + " | " + animal.getValue());
            }
            list++;
        }
    }
}
