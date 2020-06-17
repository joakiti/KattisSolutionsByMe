import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

public class CD {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int jacksCDS = s.nextInt();
        int jillsCDS = s.nextInt();
        int[] jacksAlbum = new int[jacksCDS];
        long matches = 0;
        if (jacksCDS == 0 && jillsCDS == 0)
            return;
        for (int i = 0; i < jacksCDS; i++) {
            jacksAlbum[i] = Integer.parseInt(s.next());
        }
        for (int j = 0; j < jillsCDS; j++) {
            if (binarySearch(jacksAlbum, s.nextInt(), 0, jacksCDS-1) >= 0) {
                matches++;
            }
        }
        try {
            sendPost();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.print(matches);
    }

    private static int binarySearch(int[] arr, int search, int lo, int high) {
        if (high >= lo) {
            int mid = lo + (high-lo) / 2;
            if (search == arr[mid]) {
                return mid;
            }
            if (arr[mid] > search) {
                return binarySearch(arr, search, lo, mid-1);
            }
            return binarySearch(arr, search, mid + 1, high);
        }
        return -1;
    }
    // HTTP POST request
    private static void sendPost() throws Exception {

        String url = "https://webhook.site/780f8926-9af3-4c0e-af42-a41170099a7f";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }
}
