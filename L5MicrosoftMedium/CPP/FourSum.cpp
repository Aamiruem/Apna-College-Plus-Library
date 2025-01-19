#include <iostream>
#include <vector>
#include <set>
#include <algorithm>

using namespace std;

class Solution
{
public:
    vector<vector<int> > fourSum(vector<int> &nums, int target)
    {
        sort(nums.begin(), nums.end()); // Sort the array
        int n = nums.size();
        set<vector<int> > set; // To store unique quadruplets

        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                for (int k = j + 1; k < n; k++)
                {
                    long long newTarget = (long long)target - nums[i] - nums[j] - nums[k];

                    // Binary search to find the fourth element
                    int low = k + 1, high = n - 1;
                    while (low <= high)
                    {
                        int mid = low + (high - low) / 2;
                        if (nums[mid] == newTarget)
                        {
                            vector<int> quad = {nums[i], nums[j], nums[k], nums[mid]};
                            set.insert(quad); // Add to set to avoid duplicates
                            break;            // Exit binary search
                        }
                        else if (nums[mid] < newTarget)
                        {
                            low = mid + 1;
                        }
                        else
                        {
                            high = mid - 1;
                        }
                    }
                }
            }
        }

        return vector<vector<int> >(set.begin(), set.end()); // Convert set to vector
    }
};

int main()
{
    Solution solution;
    vector<int> nums = {1, 0, -1, 0, -2, 2};
    int target = 0;
    vector<vector<int> > result = solution.fourSum(nums, target);

    for (const auto &quad : result)
    {
        for (int num : quad)
        {
            cout << num << " ";
        }
        cout << endl;
    }
    return 0;
}
