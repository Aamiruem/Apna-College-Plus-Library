#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution
{
public:
    int minPairSum(vector<int> &nums)
    {
        int ans = 0;
        sort(nums.begin(), nums.end()); // Sort the array

        for (int i = 0; i < nums.size() / 2; i++)
        {
            ans = max(ans, nums[i] + nums[nums.size() - 1 - i]);
        }

        return ans;
    }
};

int main()
{
    Solution solution;
    vector<int> nums = {3, 5, 2, 7, 1, 6, 4}; // Corrected vector initialization

    int minPairSum = solution.minPairSum(nums); // Corrected function call syntax

    cout << "Minimum Pair Sum: " << minPairSum << endl; // Corrected output syntax

    return 0; // Corrected return statement
}









// How This Code Works
// Sorting the array

// We sort nums in ascending order.
// Pairing numbers from both ends

// We pair the smallest and largest elements, then the second smallest with the second largest, and so on.
// This minimizes the maximum pair sum.
// Finding the maximum sum among pairs

// We update ans to store the max sum of these pairs.
// Example Run
// Input:
// cpp
// Copy code
// nums = {3, 5, 2, 7, 1, 6, 4}
// Sorted Array:
// Copy code
// {1, 2, 3, 4, 5, 6, 7}
// Pairs and Their Sums:
// scss
// Copy code
// (1,7) → 8  
// (2,6) → 8  
// (3,5) → 8  
// Output:
// yaml
// Copy code
// Minimum Pair Sum: 8
// This ensures the minimum maximum pair sum.
