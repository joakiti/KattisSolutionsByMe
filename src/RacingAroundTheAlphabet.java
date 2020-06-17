import java.util.HashMap;
import java.util.Scanner;

public class RacingAroundTheAlphabet {

    static String test = "3\n" +
            "WINNING ISN'T EVERYTHING IT'S THE ONLY THING\n" +
            "WINNERS DON'T WAIT FOR CHANCES THEY TAKE THEM\n" +
            "PAIN IS ONLY TEMPORARY BUT VICTORY IS FOREVER\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int tests = s.nextInt();
        s.nextLine();
        double circumference = Math.PI * 60; //in feet
        double distancebetweenEach = circumference/28;
        double speed = 15; //in feet /second
        int i = 0;
        HashMap<Character, Integer>  characterIntegerHashMap = new HashMap<>();
        for (char a = 'A'; a <= 'Z'; a++) {
            characterIntegerHashMap.put(a, i);
            i++;
        }
        characterIntegerHashMap.put(' ', 26);
        characterIntegerHashMap.put('\'', 27);
        while (tests -- != 0) {
            double time = 0;

            String route = s.nextLine();
            int location = characterIntegerHashMap.get(route.charAt(0));
            for (int j = 0; j < route.length(); j++) {
                int toGo = characterIntegerHashMap.get(route.charAt(j));
                double distanceGoingOneWay = (28 - (location - toGo)) % 28;
                double distanceGoingRight = (28 + (location - toGo)) % 28;

                double distance = Math.min(distanceGoingOneWay, distanceGoingRight) * (distancebetweenEach/speed);
                time += distance;
                location = toGo;
            }
            time += route.length();

            System.out.println(time);
        }
    }
}
