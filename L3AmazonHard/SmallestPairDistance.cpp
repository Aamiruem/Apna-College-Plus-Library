#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int smallestDistancePair(vector<int> &nums, int k)
{
    sort(nums.begin(), nums.end());
    int n = nums.size();
    int l = 0, r = nums[n - 1] - nums[0];

    while (l < r)
    {
        int mid = l + (r - l) / 2;
        int count = 0;

        // Count the number of pairs with distance <= mid
        for (int i = 0, j = 0; i < n; i++)
        {
            while (j < n && nums[j] - nums[i] <= mid)
            {
                j++;
            }
            count += (j - i - 1); // Count pairs (i, i+1), (i, i+2), ..., (i, j-1)
        }

        if (count < k)
        {
            l = mid + 1;
        }
        else
        {
            r = mid;
        }
    }
    return l;
}

int main()
{
    vector<int> nums = {1, 6, 1};
    int k = 3;
    cout << smallestDistancePair(nums, k) << endl; // Output: 5
    return 0;
}
