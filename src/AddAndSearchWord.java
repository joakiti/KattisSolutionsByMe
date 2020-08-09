import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AddAndSearchWord {

    public static void main(String[] args) {
        var b = new int[]{1,2,3,4,5,6,7};
        rotate(b, 3);
        System.out.println("test");
    }
    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        int index = nums.length;
        int[] copy = new int[nums.length];
        System.arraycopy(nums, index - k, copy, 0, k);
        System.arraycopy(nums, 0, copy, k, index - k);
        System.arraycopy(copy, 0, nums, 0, index);
    }

    class WordDictionary {

        private final TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            root = new TrieNode();
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            TrieNode current = root;

            for (char l : word.toCharArray()) {
                current = current.getChildren().computeIfAbsent(l, c -> new TrieNode());
            }
            current.setWord(true);
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            LinkedList<TrieNode> currentList = new LinkedList<>();
            currentList.add(root);
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                LinkedList<TrieNode> newList = new LinkedList<>();
                while (!currentList.isEmpty()) {
                    TrieNode current = currentList.pop();
                    if (ch == '.') {
                        newList.addAll(current.getChildren().values());
                        continue;
                    }
                    TrieNode node = current.getChildren().get(ch);
                    if (node != null) {
                        newList.add(node);
                    }
                }
                currentList = newList;

            }
            boolean isWord = false;
            for (TrieNode n : currentList) {
                isWord = n.isWord() || isWord;
            }
            return isWord;
        }

        public class TrieNode {

            private boolean isWord;
            private HashMap<Character, TrieNode> children = new HashMap<>();


            public HashMap<Character, TrieNode> getChildren() {
                return children;
            }

            public void setWord(boolean word) {
                isWord = word;
            }


            public boolean isWord() {
                return isWord;
            }


            // ...
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}
