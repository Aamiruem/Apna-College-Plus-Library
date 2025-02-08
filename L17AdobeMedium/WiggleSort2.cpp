#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

class Solution
{
public:
    void wiggleSort(vector<int> &nums)
    {
        int n = nums.size();
        priority_queue<int> q(nums.begin(), nums.end()); // Max heap

        for (int i = 1; i < n; i += 2)
        {
            nums[i] = q.top();
            q.pop();
        }

        for (int i = 0; i < n; i += 2)
        {
            nums[i] = q.top();
            q.pop();
        }
    }
};

int main()
{
    Solution solution;
    vector<int> nums = {3, 5, 2, 1, 6, 4};

    cout << "Before: ";
    for (int num : nums)
    {
        cout << num << " ";
    }
    cout << endl;

    solution.wiggleSort(nums);

    cout << "After: ";
    for (int num : nums)
    {
        cout << num << " ";
    }
    cout << endl;

    return 0;
}
