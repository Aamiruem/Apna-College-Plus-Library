public class ClimbingStairs {
    public int climbStair(int n) {
        if (n == 0) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
        
    public static void main(String[] args) {
        ClimbingStairs obj = new ClimbingStairs();
        int n = 3;
        System.out.println("Number of ways to climb " + n + " stairs: " + obj.climbStair(n)); // Output: 3

        n = 4;
        System.out.println("Number of ways to climb " + n + " stairs: " + obj.climbStair(n)); // Output: 5
    }
}
