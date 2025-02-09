
public class PalindromePartitioning2 {

        private boolean isPalindrome(int i, int j, String s) {
            if (i >= j) {
                return true;
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            return isPalindrome(i + 1, j - 1, s);
        }

        public int minCut(String str) {
            int n = str.length();
            int[] dp = new int[n + 1];
            dp[n] = 0;

            for (int i = n - 1; i >= 0; i--) {
                int mini = Integer.MAX_VALUE;
                for (int k = i; k < n; k++) {
                    if (isPalindrome(i, k, str)) {
                        int x = 1 + dp[k + 1];
                        mini = Math.min(mini, x);
                    }
                }
                dp[i] = mini;
            }
            return dp[0] - 1;
        }

        public static void main(String[] args) {
            PalindromePartitioning2 solution = new PalindromePartitioning2();
            String str = "aabba";
            int result = solution.minCut(str);
            System.out.println("Minimum cuts: " + result);
        }
    }
