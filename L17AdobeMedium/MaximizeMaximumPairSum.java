// Explanation of the Code
// Sorting the Array

// We sort nums so that the smallest values appear first.
// Pairing Smallest & Largest Values

// The smallest number is paired with the largest.
// The second smallest is paired with the second largest, and so on.
// Finding Maximum Pair Sum

// The loop runs half the length of the array, pairing numbers from both ends.
// Math.max() keeps track of the largest pair sum.
// Example Run
// Input:
// java
// Copy code
// nums = {3, 5, 2, 7, 1, 6, 4}
// Sorted Array:
// Copy code
// {1, 2, 3, 4, 5, 6, 7}
// Pairs & Their Sums:
// scss
// Copy code
// (1,7) → 8  
// (2,6) → 8  
// (3,5) → 8  
// Output:
// yaml
// Copy code
// Minimum Pair Sum: 8











import java.util.Arrays;

public class Main {

    public static void main(String[] args) { // Fixed Stringll to String[]
        MaximizeMaximumPairSum solution = new MaximizeMaximumPairSum();
        int[] nums = {3, 5, 2, 7, 1, 6, 4}; // Fixed array initialization

        int minPairSum = solution.minPairSum(nums); // Fixed function call syntax

        System.out.println("Minimum Pair Sum: " + minPairSum); // Fixed syntax
    }
}

public class MaximizeMaximumPairSum {

    public int minPairSum(int[] nums) {
        int ans = 0;
        Arrays.sort(nums); // Sort the array

        for (int i = 0; i < nums.length / 2; i++) { // Fixed incorrect comparison symbol
            ans = Math.max(ans, nums[i] + nums[nums.length - 1 - i]); // Fixed syntax error
        }

        return ans; // Fixed missing semicolon
    }
}
