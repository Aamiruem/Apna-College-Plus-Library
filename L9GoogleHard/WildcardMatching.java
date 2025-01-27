
public class WildcardMatching {

    private int[][] dp;

    public boolean isMatch(String s, String p) {
        dp = new int[s.length() + 1][p.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= p.length(); j++) {
                dp[i][j] = -1; // Initialize DP table with -1 (uncomputed state)
            }
        }
        return help(s, p, 0, 0);
    }

    private boolean help(String s, String p, int i, int j) {
        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }

        // If both strings are fully processed
        if (i == s.length() && j == p.length()) {
            dp[i][j] = 1;
            return true;
        }

        // If the pattern is fully processed but string is not
        if (j == p.length()) {
            dp[i][j] = 0;
            return false;
        }

        boolean match = false;

        // Handle '*' in the pattern
        if (p.charAt(j) == '*') {
            match = (i < s.length() && help(s, p, i + 1, j)) || help(s, p, i, j + 1);
        } // Handle '?' or exact character match
        else if (i < s.length() && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))) {
            match = help(s, p, i + 1, j + 1);
        }

        dp[i][j] = match ? 1 : 0;
        return match;
    }

    public static void main(String[] args) {
        WildcardMatching solution = new WildcardMatching();

        // Test case 1: Matching string "aa" with pattern "a"
        String s1 = "aa";
        String p1 = "a";
        System.out.println("isMatch(" + s1 + ", " + p1 + "): " + solution.isMatch(s1, p1));

        // Test case 2: Matching string "aa" with pattern "*"
        String s2 = "aa";
        String p2 = "*";
        System.out.println("isMatch(" + s2 + ", " + p2 + "): " + solution.isMatch(s2, p2));

        // Test case 3: Matching string "cb" with pattern "?a"
        String s3 = "cb";
        String p3 = "?a";
        System.out.println("isMatch(" + s3 + ", " + p3 + "): " + solution.isMatch(s3, p3));

        // Test case 4: Matching string "adceb" with pattern "*a*b"
        String s4 = "adceb";
        String p4 = "*a*b";
        System.out.println("isMatch(" + s4 + ", " + p4 + "): " + solution.isMatch(s4, p4));
    }
}
