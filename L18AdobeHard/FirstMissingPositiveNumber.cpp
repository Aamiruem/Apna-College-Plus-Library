#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    int firstMissingPositive(vector<int> &nums)
    {
        int n = nums.size();

        // Rearrange the array
        for (int i = 0; i < n; i++)
        {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1])
            {
                swap(nums[i], nums[nums[i] - 1]);
            }
        }

        // Find the first missing positive integer
        for (int i = 0; i < n; i++)
        {
            if (nums[i] != i + 1)
            {
                return i + 1;
            }
        }

        // If all positive integers from 1 to n are present, return n + 1
        return n + 1;
    }
};

int main()
{
    Solution solution;
    vector<int> nums = {3, 4, -1, 1};
    int result = solution.firstMissingPositive(nums);
    cout << "The first missing positive integer is: " << result << endl;

    return 0;
}
