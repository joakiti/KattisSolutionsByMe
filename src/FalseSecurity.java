import java.util.*;

public class FalseSecurity {

    static String test = "AKADTOF_IBOETATUK_IJN";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        HashMap<Character, String> letterToMorse = new HashMap<>();
        HashMap<String, Character> morseToLetter = new HashMap<>();

        letterToMorse.put('A', ".-");
        letterToMorse.put('B', "-...");
        letterToMorse.put('C', "-.-.");
        letterToMorse.put('D', "-..");
        letterToMorse.put('E', ".");
        letterToMorse.put('F', "..-.");
        letterToMorse.put('G', "--.");
        letterToMorse.put('H', "....");
        letterToMorse.put('I', "..");
        letterToMorse.put('J', ".---");
        letterToMorse.put('K', "-.-");
        letterToMorse.put('L', ".-..");
        letterToMorse.put('M', "--");
        letterToMorse.put('N', "-.");
        letterToMorse.put('O', "---");
        letterToMorse.put('P', ".--.");
        letterToMorse.put('Q', "--.-");
        letterToMorse.put('R', ".-.");
        letterToMorse.put('S', "...");
        letterToMorse.put('T', "-");
        letterToMorse.put('U', "..-");
        letterToMorse.put('V', "...-");
        letterToMorse.put('W', ".--");
        letterToMorse.put('X', "-..-");
        letterToMorse.put('Y', "-.--");
        letterToMorse.put('Z', "--..");
        letterToMorse.put('_', "..--");
        letterToMorse.put(',', ".-.-");
        letterToMorse.put('.', "---.");
        letterToMorse.put('?', "----");
        for (Map.Entry<Character, String> e :
                letterToMorse.entrySet()) {
            morseToLetter.put(e.getValue(), e.getKey());
        }

        while (s.hasNext()) {
            LinkedList<Integer> lengths = new LinkedList<>();
            String line = s.nextLine();
            StringBuilder morse = new StringBuilder();
            for (int i = 0; i < line.length(); i++) {
                lengths.add(letterToMorse.get(line.charAt(i)).length());
                morse.append(letterToMorse.get(line.charAt(i)));
            }
            Collections.reverse(lengths);
            int currentPos = 0;
            StringBuilder answer = new StringBuilder();
            while(!lengths.isEmpty()) {
                int increment = lengths.poll();
                String charToDecipher = morse.substring(currentPos, currentPos + increment);
                currentPos += increment;
                answer.append(morseToLetter.get(charToDecipher));
            }
            System.out.println(answer);
        }
    }
}
