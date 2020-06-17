import java.util.ArrayList;
import java.util.Scanner;

public class encodedMessage {
    /**
     private static String poem = "RosesAreRedVioletsAreBlue";
     private static String expected = "eedARBtVrolsiesuAoReerles";
     **/
    public static void main(String args[]) {
        System.out.println(MyEncoder.decode("EarSvyeqeBsuneMa"));
        Scanner s = new Scanner(System.in);
        int numberOfMessages = Integer.parseInt(s.next());
        ArrayList<String> encodeMessages = new ArrayList<>();
        while (numberOfMessages != 0) {
            System.out.println(MyEncoder.decode(s.next()));
            numberOfMessages--;
        }
    }
    /**
     private static Boolean testPoemDecode() {
     return MyEncoder.decode(expected) == poem;
     }

     private static Boolean testPoemEncode() {
     return MyEncoder.encode(poem).equals(expected);
     }
     **/
}

class MyEncoder {
    static String decode(String args) {
        char[] box = args.toCharArray();
        char[] returnval = new char[box.length];
        int pow = (int) Math.round(Math.sqrt(box.length));
        for (int i = 0; i < pow; i++) {
            for (int j = 0; j < pow; j++) {
                returnval[j +((i*pow))] = box[(pow-1+(j*pow))-i];
            }
        }
        return new String(returnval);
    }
    /**
     static String encode(String args) {
     char[] box = args.toCharArray();
     int pow = (int) Math.round(Math.sqrt(box.length));
     int adjustToColumnCounter = 0;
     for (int i = 0; i < pow; i++) {
     for (int j = 1; j <= pow; j++) {
     box[(pow-1+adjustToColumnCounter)-i] = box[j +(i*pow) - 1];
     adjustToColumnCounter += pow;
     }
     adjustToColumnCounter = 0;
     }
     return new String(box);
     }
     **/
}