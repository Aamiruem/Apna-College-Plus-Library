import java.util.Arrays;

public class countPalindromicSubsequences {
    public static void main(String[] args) {
        final int MOD = 1_000_000_007;
        String s = "103301";
        int n = s.length();

        int[][][] pre = new int[n][10][10];
        int[][][] suf = new int[n][10][10];

        int[] counts = new int[10];

        // Compute prefix occurrences
        for (int i = 0; i < n; i++) {
            int dig = s.charAt(i) - '0';

            if (i >= 1) {
                for (int j = 0; j <= 9; j++) {
                    for (int k = 0; k <= 9; k++) {
                        pre[i][j][k] = pre[i - 1][j][k];
                    }
                }
            }

            for (int j = 0; j <= 9; j++) {
                pre[i][j][dig] = (pre[i][j][dig] + counts[j]) % MOD;
            }

            counts[dig]++;
        }

        // Reset counts for suffix computation
        Arrays.fill(counts, 0);

        // Compute suffix occurrences
        for (int i = n - 1; i >= 0; i--) {
            int dig = s.charAt(i) - '0';

            if (i < n - 1) {
                for (int j = 0; j <= 9; j++) {
                    for (int k = 0; k <= 9; k++) {
                        suf[i][j][k] = suf[i + 1][j][k];
                    }
                }
            }

            for (int j = 0; j <= 9; j++) {
                suf[i][j][dig] = (suf[i][j][dig] + counts[j]) % MOD;
            }

            counts[dig]++;
        }

        // Compute the final answer
        int ans = 0;
        for (int i = 1; i < n - 1; i++) { // Ensuring valid index range
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    ans = (int) ((ans + (1L * pre[i - 1][j][k] * suf[i + 1][j][k]) % MOD) % MOD);
                }
            }
        }

        System.out.println("Count of valid numbers: " + ans);
    }
    
}
