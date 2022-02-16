import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

class kMostFrequentStrings {

    public static void main(String[] args) {
    }

    public static List<String> topKFrequent(String[] words, int k) {
        TreeMap<String, Integer> wordToCount = new TreeMap<>();
        for (String word :
                words) {
            wordToCount.putIfAbsent(word, 0);
            wordToCount.put(word, wordToCount.get(word) + 1);
        }

        return wordToCount.entrySet().stream().sorted((o1, o2) -> {
            int comparison = Integer.compare(o2.getValue(), o1.getValue());
            if (comparison != 0) {
                return comparison;
            } else return o1.getKey().compareTo(o2.getKey());
        }).limit(k).map(x -> x.getKey()).collect(Collectors.toList());

    }
}