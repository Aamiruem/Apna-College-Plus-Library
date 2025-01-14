#include <iostream>
#include <unordered_map>
#include <vector>
using namespace std;

unordered_map<int, bool> memo; // Memoization map

bool helper(const vector<int> &nums, int i)
{
    if (i == nums.size() - 1)
    {
        return true; // Reached the last index
    }
    if (i >= nums.size() || nums[i] == 0)
    {
        return false; // Out of bounds or stuck
    }
    if (memo.find(i) != memo.end())
    {
        return memo[i]; // Return memoized result
    }

    for (int j = 1; j <= nums[i]; j++)
    {
        if (helper(nums, i + j))
        {
            return memo[i] = true; // Store result in memo and return
        }
    }

    return memo[i] = false; // Store result in memo and return
}

bool jumpGame(const vector<int> &nums)
{
    memo.clear();
    return helper(nums, 0);
}

int main()
{
    vector<int> nums = {2, 3, 1, 1, 4};
    cout << (jumpGame(nums) ? "true" : "false") << endl; // true
    return 0;
}
