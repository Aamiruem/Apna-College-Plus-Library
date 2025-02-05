
public class LastLexicographicalSubstrings {

    public static String lastSubstring(String s) {
        int n = s.length();
        int i = 0, j = 1, k = 0;

        // Compare substrings starting at i and j
        while (j + k < n) {
            if (s.charAt(i + k) == s.charAt(j + k)) {
                k++; // Continue comparing next characters
            } else if (s.charAt(i + k) < s.charAt(j + k)) {
                // Found a lexicographically larger substring, move i forward
                i = j;
                j = i + 1;
                k = 0; // Reset k since we start a new comparison
            } else {
                // j's substring is smaller, move j forward
                j = j + k + 1;
                k = 0;
            }
        }
        return s.substring(i);
    }

    public static void main(String[] args) {
        String s = "abab";
        System.out.println(lastSubstring(s)); // Output: "bab"
    }
}
