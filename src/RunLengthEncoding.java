import java.util.Scanner;

public class RunLengthEncoding {

    static String test = "D H3e2l3o1W1o3r4l2d1!2\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        char encode = s.next().charAt(0);


        StringBuilder ans = new StringBuilder();
        String message = s.next();
        if (encode == 'E') {
            //do encoding
            for (int i = 0; i < message.length(); i++) {
                int count = 1;
                ans.append(message.charAt(i));
                while (i < message.length() - 1 && message.charAt(i + 1) == message.charAt(i)) {
                    i++;
                    count++;
                }
                ans.append(count);
            }
        }
        else {
            //do decoding
            for (int i = 0; i < message.length(); i+=2) {
                char toAppend = message.charAt(i);
                int count = message.charAt(i+1) - '0';
                ans.append(String.valueOf(toAppend).repeat(Math.max(0, count)));
            }
        }


        System.out.println(ans);
    }
}
