
// import java.util.*;

// // Trie Node Definition
// class TrieNode {

//     boolean isWord;
//     TrieNode[] children;

//     public TrieNode() {
//         this.isWord = false;
//         this.children = new TrieNode[26];
//     }
// }

// // Function to add a word to the Trie
// public class TopKFrequentWords {

//     private static void addWord(TrieNode root, String word) {
//         TrieNode cur = root;
//         for (char ch : word.toCharArray()) {
//             int idx = ch - 'a';
//             if (cur.children[idx] == null) {
//                 cur.children[idx] = new TrieNode();
//             }
//             cur = cur.children[idx];
//         }
//         cur.isWord = true;
//     }

//     // Function to get words from the Trie
//     private static void getWords(TrieNode root, String prefix, List<String> res, int k) {
//         if (k == 0) {
//             return;
//         }

//         if (root.isWord) {
//             k--;
//             res.add(prefix);
//             if (k == 0) {
//                 return;
//             }
//         }

//         for (int i = 0; i < 26; i++) {
//             if (root.children[i] != null) {
//                 getWords(root.children[i], prefix + (char) ('a' + i), res, k);
//             }
//         }
//     }

//     public static void main(String[] args) {
//         int k = 2;
//         String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
//         int n = words.length;

//         // Frequency Map to count occurrences of words
//         Map<String, Integer> freqMap = new HashMap<>();
//         for (String word : words) {
//             freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
//         }

//         List<String> res = new ArrayList<>();
//         @SuppressWarnings("unused")
//         TrieNode trie = new TrieNode();
//         List<TrieNode> bucket = new ArrayList<>(Collections.nCopies(n + 1, new TrieNode()));

//         // Insert words into the Trie based on frequency
//         for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
//             addWord(bucket.get(entry.getValue()), entry.getKey());
//         }

//         // Collect words from the Trie starting from the highest frequency
//         for (int i = n; i >= 0 && k > 0; i--) {
//             getWords(bucket.get(i), "", res, k);
//         }

//         // Output the result
//         for (String word : res) {
//             System.out.print(word + " ");
//         }
//     }
// }














import java.util.*;

class TopKFrequentWords {

    private int k;
    private List<String> res;

    // Trie Node Definition
    class TrieNode {

        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }

    // Function to add a word to the Trie
    private void addWord(TrieNode root, String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    // Function to get words from the Trie
    private void getWords(TrieNode root, String prefix) {
        if (k <= 0) {
            return;
        }

        if (root.isWord) {
            k--;
            res.add(prefix);
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                getWords(root.children[i], prefix + (char) ('a' + i));
            }
        }
    }

    // Main function to get the top k frequent words
    public List<String> topKFreq(String[] words, int k) {
        this.k = k;
        int n = words.length;
        TrieNode[] bucket = new TrieNode[n + 1];
        Map<String, Integer> cnt = new HashMap<>();

        // Count frequency of each word
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }

        // Initialize the bucket for each frequency
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            if (bucket[entry.getValue()] == null) {
                bucket[entry.getValue()] = new TrieNode();
            }
            addWord(bucket[entry.getValue()], entry.getKey());
        }

        res = new ArrayList<>();

        // Collect words from the bucket starting from the highest frequency
        for (int i = n; i >= 0; i--) {
            if (bucket[i] != null) {
                getWords(bucket[i], "");
            }
            if (k == 0) {
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TopKFrequentWords obj = new TopKFrequentWords();
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        List<String> res = obj.topKFreq(words, k);
        for (String word : res) {
            System.out.println(word);
        }
    }
}
