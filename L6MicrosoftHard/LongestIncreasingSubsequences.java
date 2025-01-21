// package L6MicrosoftHard;

import java.util.Arrays;

public class LongestIncreasingSubsequences {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n];
        Arrays.fill(dp, 1); // Every element is an LIS of length 1

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequences sol = new LongestIncreasingSubsequences();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Length of LIS: " + sol.lengthOfLIS(nums));
    }
}
