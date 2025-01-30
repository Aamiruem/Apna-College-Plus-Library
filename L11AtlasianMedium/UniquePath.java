public class UniquePath {
    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };

        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

        dp[n - 1][m - 1] = (grid[n - 1][m - 1] == 0) ? 1 : 0; // Base case

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i + 1 < n) {
                    dp[i][j] += dp[i + 1][j];
                }
                if (j + 1 < m) {
                    dp[i][j] += dp[i][j + 1];
                }
            }
        }

        System.out.println(dp[0][0]);
    }
}
