

public class LongestPalindromeSubstrings {

    public static void longestPalSubstr(String s) {
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Odd-length palindrome
            int l = i, r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > end - start) {
                    start = l;
                    end = r + 1;
                }
                l--;
                r++;
            }

            // Even-length palindrome
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > end - start) {
                    start = l;
                    end = r + 1;
                }
                l--;
                r++;
            }
        }

        // Print the longest palindromic substring
        System.out.println("Longest Palindromic Substring: " + s.substring(start, end));
    }

    public static void main(String[] args) {
        String s = "babad";
        longestPalSubstr(s);
    }
}
