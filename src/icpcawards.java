import java.util.*;

public class icpcawards {

    static String test = "30\n" +
            "Seoul ACGTeam\n" +
            "VNU LINUX\n" +
            "SJTU Mjolnir\n" +
            "VNU WINDOWS\n" +
            "NTU PECaveros\n" +
            "HUST BKJuniors\n" +
            "HCMUS HCMUSSerendipity\n" +
            "VNU UBUNTU\n" +
            "SJTU Metis\n" +
            "HUST BKDeepMind\n" +
            "HUST BKTornado\n" +
            "HCMUS HCMUSLattis\n" +
            "NUS Tourism\n" +
            "VNU DOS\n" +
            "HCMUS HCMUSTheCows\n" +
            "VNU ANDROID\n" +
            "HCMUS HCMUSPacman\n" +
            "HCMUS HCMUSGeomecry\n" +
            "UIndonesia DioramaBintang\n" +
            "VNU SOLARIS\n" +
            "UIndonesia UIChan\n" +
            "FPT ACceptable\n" +
            "HUST BKIT\n" +
            "PTIT Miners\n" +
            "PSA PSA\n" +
            "DaNangUT BDTTNeverGiveUp\n" +
            "VNU UNIXBSD\n" +
            "CanTho CTUA2LTT\n" +
            "Soongsil Team10deung\n" +
            "Soongsil BezzerBeater";
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        LinkedHashMap<String, String> winners = new LinkedHashMap<>();

        int n = s.nextInt();

        while (n-- != 0) {
            String university = s.next();
            String team = s.next();

            if (winners.getOrDefault(university, "").equals("")) {
                winners.put(university, team);
            }
        }
        int i = 1;
        for (Map.Entry<String,String> entry :
             winners.entrySet()) {
            if (i <= 12) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
            i++;
        }
    }
}
