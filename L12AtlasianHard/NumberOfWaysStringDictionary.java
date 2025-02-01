// import java.util.*;

// public class NumberOfWaysStringDictionary {
//     public static void main(String[] args) {
//         final int MOD = 1_000_000_007;
//         String[] words = {"acca", "bbbb", "caca"};
//         String target = "aba";

//         int n = target.length();
//         int colSize = words[0].length();

//         int[][] occur = new int[26][colSize];

//         // Count the occurrences of each character in each column
//         for (int i = 0; i < colSize; i++) {
//             for (String s : words) {
//                 occur[s.charAt(i) - 'a'][i]++;
//             }
//         }

//         // DP array
//         int[][] dp = new int[n + 1][colSize + 1];

//         // Base case: there's 1 way to form an empty string
//         for (int j = 0; j <= colSize; j++) {
//             dp[0][j] = 1;
//         }

//         // DP transition
//         for (int i = 1; i <= n; i++) {
//             for (int j = 1; j <= colSize; j++) {
//                 // Leave the character at this column
//                 dp[i][j] = dp[i][j - 1];

//                 // Pick the character if it matches target[i-1]
//                 if (occur[target.charAt(i - 1) - 'a'][j - 1] > 0) {
//                     dp[i][j] = (dp[i][j] + (int)((long)occur[target.charAt(i - 1) - 'a'][j - 1] * dp[i - 1][j - 1] % MOD)) % MOD;
//                 }
//             }
//         }

//         // Output the result
//         System.out.println(dp[n][colSize]);
//     }
// }








import java.util.*;

public class NumberOfWaysStringDictionary {
    public static void main(String[] args) {
        final int MOD = 1_000_000_007;
        String[] words = {"acca", "bbbb", "caca"};
        String target = "aba";

        int n = target.length();
        int colSize = words[0].length();

        int[][] occur = new int[26][colSize];

        // Count the occurrences of each character in each column
        for (int i = 0; i < colSize; i++) {
            for (String s : words) {
                occur[s.charAt(i) - 'a'][i]++;
            }
        }

        // DP array (use long to prevent overflow)
        long[][] dp = new long[n + 1][colSize + 1];

        // Base case: 1 way to form an empty string
        Arrays.fill(dp[0], 1);

        // DP transition
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= colSize; j++) {
                // Leave the character at this column
                dp[i][j] = dp[i][j - 1];

                // Pick the character
                dp[i][j] = (dp[i][j] + occur[target.charAt(i - 1) - 'a'][j - 1] * dp[i - 1][j - 1]) % MOD;
            }
        }

        // Output the result
        System.out.println(dp[n][colSize]);
    }
}
