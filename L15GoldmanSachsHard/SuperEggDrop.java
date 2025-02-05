
public class SuperEggDrop {

    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];

        // Base cases
        for (int i = 1; i <= K; i++) {
            dp[i][1] = 1; // 1 floor, 1 attempt

                }for (int j = 1; j <= N; j++) {
            dp[1][j] = j; // 1 egg, linear attempts
        }
        for (int k = 2; k <= K; k++) {
            for (int n = 2; n <= N; n++) {
                int low = 1, high = n, res = n;

                // Binary search to find the best floor to drop from
                while (low <= high) {
                    int mid = (low + high) / 2;
                    int breakCase = dp[k - 1][mid - 1]; // Egg breaks
                    int noBreakCase = dp[k][n - mid]; // Egg doesn't break
                    int worst = Math.max(breakCase, noBreakCase) + 1;
                    res = Math.min(res, worst);

                    if (breakCase > noBreakCase) {
                        high = mid - 1; // Try lower floors
                    } else {
                        low = mid + 1; // Try higher floors
                    }
                }
                dp[k][n] = res;
            }
        }
        return dp[K][N];
    }

    public static void main(String[] args) {
        SuperEggDrop obj = new SuperEggDrop();
        System.out.println(obj.superEggDrop(2, 6)); // Output: 3
    }
}
