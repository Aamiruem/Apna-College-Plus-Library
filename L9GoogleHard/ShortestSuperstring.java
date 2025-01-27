
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ShortestSuperstring {

    public String shortestSuperstring(String[] words) {
        Map<String, String> map = new HashMap<>();
        int unusedWords = 0;

        // Mark all words as unused using a bitmask
        for (int i = 0; i < words.length; i++) {
            unusedWords |= 1 << i;
        }

        // Call the recursive function to find the shortest superstring
        return shortestSuperstring(words, "", unusedWords, map);
    }

    // Recursive function to find the shortest superstring
    private String shortestSuperstring(String[] words, String startWord, int unused, Map<String, String> map) {
        if (unused == 0) { // Base case: all words have been used
            return startWord;
        }

        // Create a unique key for the current start word and unused words combination
        String key = startWord + "|" + unused;

        // If the result for this combination has already been calculated, return it
        if (map.containsKey(key)) {
            return map.get(key);
        }

        String shortest = null;

        // Try to append each unused word to the start word
        for (int i = 0; i < words.length; i++) {
            if (!isConsumed(unused, i)) { // If the i-th word has not been used yet

                // Get the shortest superstring starting from the ith word
                String superstring = shortestSuperstring(words, words[i], consume(unused, i), map);

                // Append the shortest superstring to the start word
                String appended = overlapAppend(startWord, superstring);

                // Keep the shortest
                if (shortest == null || appended.length() < shortest.length()) {
                    shortest = appended;
                }
            }
        }

        // Cache the result for this combination
        map.put(key, shortest);
        return shortest;
    }

    // Check if a word is already consumed using the bitmask
    private boolean isConsumed(int unused, int index) {
        return (unused & (1 << index)) == 0;
    }

    // Consume a word by updating the bitmask
    private int consume(int unused, int index) {
        return unused & ~(1 << index);
    }

    // Append two strings with maximum overlap
    private String overlapAppend(String a, String b) {
        int maxOverlap = 0;
        for (int i = 1; i <= Math.min(a.length(), b.length()); i++) {
            if (a.endsWith(b.substring(0, i))) {
                maxOverlap = i;
            }
        }
        return a + b.substring(maxOverlap);
    }

    public static void main(String[] args) {
        ShortestSuperstring solver = new ShortestSuperstring();

        // Test Case 1
        String[] words1 = {"cat", "dog", "bird", "elephant"};
        String result1 = solver.shortestSuperstring(words1);
        System.out.println(Arrays.toString(words1) + " => " + result1);

        // Test Case 2
        String[] words2 = {"abc", "def", "ghi", "jkl"};
        String result2 = solver.shortestSuperstring(words2);
        System.out.println(Arrays.toString(words2) + " => " + result2);

        // Test Case 3
        String[] words3 = {"abc", "bcd", "cde", "def"};
        String result3 = solver.shortestSuperstring(words3);
        System.out.println(Arrays.toString(words3) + " => " + result3);
    }
}
