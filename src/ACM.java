import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ACM {
/**
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        PriorityQueue<int[]> queue = new PriorityQueue<>(10, Comparator.comparingInt(o -> o[1]));
        String S = "asd";
        TreeMap<Character, int[]> mapToStartEndSeen = new Hash<>();
        char[] chars = S.toCharArray();
        for (int i = 0; i < S.length(); i++) {
            if (mapToStartEndSeen.containsKey(chars[i])) {
                mapToStartEndSeen.put(chars[i], new int[]{mapToStartEndSeen.get(chars[i])[0], i});
            }
            else {
                mapToStartEndSeen.put(chars[i], new int[]{i,i});
            }
        }
    }
    public List<Integer> partitionLabels(String S) {
        HashMap<Character, int[]> mapToStartEndSeen = new HashMap<>();
        char[] chars = S.toCharArray();
        for (int i = 0; i < S.length(); i++) {
            if (mapToStartEndSeen.containsKey(chars[i])) {
                mapToStartEndSeen.put(chars[i], new int[]{mapToStartEndSeen.get(chars[i])[0], i});
            }
            else {
                mapToStartEndSeen.put(chars[i], new int[]{i,i});
            }
        }
        ArrayList<Integer> ans = new ArrayList();

        HashSet<Character> distinctChars = S.chars().distinct().mapToObj(i -> (char) i).collect(Collectors.toCollection(HashSet::new));
        for (Character c : distinctChars) {
            int[] current = mapToStartEndSeen.get(c);
            for (Character couldBeOutside : distinctChars) {
                if (c.equals(couldBeOutside)) {
                    continue;
                }
                else {
                    int[] neighbour = mapToStartEndSeen.get(couldBeOutside);
                    //If the neighbour encompasses the current
                    if (neighbour[0] < current[0] && neighbour[1] > current[1]) {
                        //If it does, then we cannot split at current
                        break;
                    }
                }
            }
            //If we reach this point, it is because we have not breaked earlier, and can split here
            ans.add(current[1] - current[0] + 1);
        }
        return ans;
    }
 **/
}
