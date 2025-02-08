#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution
{
public:
    int minimumTotal(vector<vector<int> > &triangle)
    {
        int n = triangle.size();
        vector<int> dp(triangle[n - 1]); // Start with last row

        for (int row = n - 2; row >= 0; row--)
        { // Bottom-up approach
            for (int col = 0; col < triangle[row].size(); col++)
            {
                dp[col] = triangle[row][col] + min(dp[col], dp[col + 1]);
            }
        }

        return dp[0]; // The minimum path sum
    }
};

int main()
{
    Solution solution;

    vector<vector<int> > triangle = {
        {2},
        {3, 4},
        {6, 5, 1},
        {4, 1, 8, 3}};

    int minTotal = solution.minimumTotal(triangle);
    cout << "Minimum Total: " << minTotal << endl;

    return 0;
}


//input parameters
//     2
//    3 4
//   6 5 1
//  4 1 8 3



// Starting from the bottom row:
// Row 3 (Base): [4, 1, 8, 3]
// Row 2: [6+1=7, 5+1=6, 1+3=4] → [7, 6, 4]
// Row 1: [3+6=9, 4+6=10] → [9, 10]
// Row 0: [2+9=11] → [11]




// Time & Space Complexity
// Time Complexity: O(n²) (Iterates through the triangle)
// Space Complexity: O(n) (Optimized to a single array)
