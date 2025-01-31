#include <bits/stdc++.h>
using namespace std;

int main()
{
    vector<int> nums = {1, 3, -1, -3, 5, 3, 6, 7};
    int k = 3;
    int n = nums.size();

    deque<int> dq;
    vector<int> ans;

    // Process first k elements
    for (int i = 0; i < k; i++)
    {
        while (!dq.empty() && nums[dq.back()] <= nums[i])
        {
            dq.pop_back();
        }
        dq.push_back(i);
    }

    // Process rest of the elements
    for (int i = k; i < n; i++)
    {
        // Store the maximum of the current window
        ans.push_back(nums[dq.front()]);

        // Remove elements not in the current window
        while (!dq.empty() && dq.front() <= i - k)
        {
            dq.pop_front();
        }

        // Remove elements smaller than the current element
        while (!dq.empty() && nums[dq.back()] <= nums[i])
        {
            dq.pop_back();
        }

        dq.push_back(i);
    }

    // Push the last window's maximum
    ans.push_back(nums[dq.front()]);

    // Print the result
    for (int i = 0; i < ans.size(); i++)
    {
        cout << ans[i] << " ";
    }

    return 0;
}
