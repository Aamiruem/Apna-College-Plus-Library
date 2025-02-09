
// import java.util.Arrays;

// public class ReducingDishes {

//     public int maxSatisfaction(int[] satisfaction) {
//         Arrays.sort(satisfaction);
//         int n = satisfaction.length;
//         int total = 0;
//         int maxSum = 0;

//         // Start from the end of the array and move towards the start
//         for (int i = n - 1; i >= 0; i--) {
//             total += satisfaction[i];
//             if (total < 0) {
//                 break;
//             }
//             maxSum += total;
//         }

//         return maxSum;
//     }

//     public static void main(String[] args) {
//         ReducingDishes rd = new ReducingDishes();
//         int[] satisfaction = {-1, -8, 0, 5, -9};
//         System.out.println(rd.maxSatisfaction(satisfaction)); // Output: 14
//     }
// }




import java.util.Arrays;

public class ReducingDishes {

    private long[][] dp; // Memoization table

    private long solve(int[] nums, int i, int time) {
        if (i == nums.length) {
            return 0; // Base case: no more dishes to consider

                }if (dp[i][time] != -1) {
            return dp[i][time]; // Return precomputed result
        }
        // Two choices: take the current dish or skip it
        long take = nums[i] * time + solve(nums, i + 1, time + 1); // Take the dish
        long not_take = solve(nums, i + 1, time); // Skip the dish

        // Store the result in the memoization table
        return dp[i][time] = Math.max(take, not_take);
    }

    public long maxSatisfaction(int[] nums) {
        Arrays.sort(nums); // Sort the array to maximize satisfaction
        int n = nums.length;
        dp = new long[n + 1][n + 1]; // Initialize the memoization table
        for (long[] row : dp) {
            Arrays.fill(row, -1); // Fill the table with -1
        }
        return solve(nums, 0, 1); // Start solving from the first dish with time = 1
    }

    public static void main(String[] args) {
        ReducingDishes solution = new ReducingDishes();
        int[] A = {-1, 3, 4, 5}; // Input array
        long maxSatisfaction = solution.maxSatisfaction(A); // Compute the result
        System.out.println("Maximum Satisfaction: " + maxSatisfaction); // Output the result
    }
}
