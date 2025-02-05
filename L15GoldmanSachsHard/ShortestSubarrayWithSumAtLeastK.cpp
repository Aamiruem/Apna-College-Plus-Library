#include<bits/stdc++.h>
#include <iostream>
#include <vector>
#include <deque>
#include <climits>

using namespace std;

int shortestSubarray(vector<int> &nums, int k)
{
    int n = nums.size();
    vector<long> prefixSum(n + 1, 0);

    // Compute prefix sums
    for (int i = 0; i < n; i++)
    {
        prefixSum[i + 1] = prefixSum[i] + nums[i];
    }

    int result = INT_MAX;
    deque<int> dq;

    for (int i = 0; i <= n; i++)
    {
        // Remove indices from the front of the deque if the sum is >= k
        while (!dq.empty() && prefixSum[i] - prefixSum[dq.front()] >= k)
        {
            result = min(result, i - dq.front());
            dq.pop_front();
        }

        // Maintain the deque in increasing order of prefix sums
        while (!dq.empty() && prefixSum[i] <= prefixSum[dq.back()])
        {
            dq.pop_back();
        }

        dq.push_back(i);
    }

    return result == INT_MAX ? -1 : result;
}

int main()
{
    vector<int> nums = {2, -1, 2};
    int k = 3;
    cout << shortestSubarray(nums, k) << endl; // Output: 3
    return 0;
}
