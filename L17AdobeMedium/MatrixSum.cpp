#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution
{
public:
    int matrixSum(vector<vector<int> > &nums)
    {
        int ans = 0;
        int m = nums.size();    // Number of rows
        int n = nums[0].size(); // Number of columns

        // Sort each row in descending order
        for (auto &row : nums)
        {
            sort(row.begin(), row.end(), greater<int>());
        }

        // Find the max element in each column
        for (int j = 0; j < n; ++j)
        {
            int x = 0;
            for (int i = 0; i < m; ++i)
            {
                x = max(x, nums[i][j]); // Get the maximum value in column j
            }
            ans += x; // Add the maximum value from the column to the sum
        }

        return ans;
    }
};

int main()
{
    Solution solution;
    vector<vector<int> > nums = {
        {1, 3, 2},
        {4, 2, 5},
        {3, 1, 2}};

    int sum = solution.matrixSum(nums);
    cout << "Matrix Sum: " << sum << endl;

    return 0;
}
