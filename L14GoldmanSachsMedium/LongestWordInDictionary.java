
import java.util.*;

public class LongestWordInDictionary {

    // Function to check if 'word' is a subsequence of 's'
    private static boolean isSubsequence(String s, String word) {
        int i = 0, j = 0;
        while (i < s.length() && j < word.length()) {
            if (s.charAt(i) == word.charAt(j)) {
                j++; // Move to the next character in word
            }
            i++; // Always move in s
        }
        return j == word.length(); // If j reached word.length(), word is a subsequence
    }

    public static String findLongestWord(String s, List<String> dictionary) {
        String longestWord = "";

        // Sort dictionary: first by length (descending), then lexicographically (ascending)
        Collections.sort(dictionary, (a, b)
                -> a.length() == b.length() ? a.compareTo(b) : b.length() - a.length()
        );

        // Check each word in dictionary
        for (String word : dictionary) {
            if (isSubsequence(s, word)) { // If 'word' is a subsequence of 's'
                return word; // First valid word will be the longest due to sorting
            }
        }
        return longestWord; // No valid word found
    }

    public static void main(String[] args) {
        String s = "abpcplea"; // Input string
        List<String> dictionary = Arrays.asList("ale", "apple", "monkey", "plea");

        // Find and print the longest word
        System.out.println(findLongestWord(s, dictionary));
    }
}
