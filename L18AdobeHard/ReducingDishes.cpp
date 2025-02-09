// #include <iostream>
// #include <vector>
// #include <algorithm>

// using namespace std;

// class ReducingDishes
// {
// public:
//     int maxSatisfaction(vector<int> &satisfaction)
//     {
//         sort(satisfaction.begin(), satisfaction.end());
//         int n = satisfaction.size();
//         int total = 0;
//         int maxSum = 0;

//         // Start from the end of the array and move towards the start
//         for (int i = n - 1; i >= 0; i--)
//         {
//             total += satisfaction[i];
//             if (total < 0)
//             {
//                 break;
//             }
//             maxSum += total;
//         }

//         return maxSum;
//     }
// };

// int main()
// {
//     ReducingDishes rd;
//     vector<int> satisfaction = {-1, -8, 0, 5, -9};
//     cout << rd.maxSatisfaction(satisfaction) << endl; // Output: 14
//     return 0;
// }

#include <iostream>
#include <algorithm>
#include <cstring>
using namespace std;

class Solution
{
public:
    long dp[501][501]; // Memoization table

    long solve(int *nums, int i, int n, int time)
    {
        if (i == n)
            return 0; // Base case: no more dishes to consider
        if (dp[i][time] != -1)
            return dp[i][time]; // Return precomputed result

        // Two choices: take the current dish or skip it
        long take = nums[i] * time + solve(nums, i + 1, n, time + 1); // Take the dish
        long not_take = solve(nums, i + 1, n, time);                  // Skip the dish

        // Store the result in the memoization table
        return dp[i][time] = max(take, not_take);
    }

    long maxSatisfaction(int *nums, int n)
    {
        sort(nums, nums + n);        // Sort the array to maximize satisfaction
        memset(dp, -1, sizeof(dp));  // Initialize the memoization table with -1
        return solve(nums, 0, n, 1); // Start solving from the first dish with time = 1
    }
};

int main()
{
    Solution solution;
    int A[] = {-1, 3, 4, 5};          // Input array
    int n = sizeof(A) / sizeof(A[0]); // Calculate the size of the array

    long maxSatisfaction = solution.maxSatisfaction(A, n);       // Compute the result
    cout << "Maximum Satisfaction: " << maxSatisfaction << endl; // Output the result

    return 0;
}
