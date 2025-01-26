#include <iostream>
#include <vector>
#include <stack>
#include <algorithm>
using namespace std;

class Solution
{
public:
    int maximalRectangle(vector<vector<char> > &matrix)
    {
        if (matrix.empty() || matrix[0].empty())
            return 0;

        int rows = matrix.size();
        int cols = matrix[0].size();
        vector<int> dp(cols, 0);
        int maxArea = 0;

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                // Update the height for column j
                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
            }
            // Calculate the largest rectangle for the current row's histogram
            maxArea = max(maxArea, largestRectangleArea(dp));
        }

        return maxArea;
    }

private:
    int largestRectangleArea(vector<int> &heights)
    {
        int len = heights.size();
        vector<int> left(len), right(len);
        stack<int> stack;

        // Fill the nearest smaller to the left
        for (int i = 0; i < len; i++)
        {
            while (!stack.empty() && heights[stack.top()] >= heights[i])
            {
                stack.pop();
            }
            left[i] = stack.empty() ? -1 : stack.top();
            stack.push(i);
        }

        // Clear the stack for the right side
        while (!stack.empty())
            stack.pop();

        // Fill the nearest smaller to the right
        for (int i = len - 1; i >= 0; i--)
        {
            while (!stack.empty() && heights[stack.top()] >= heights[i])
            {
                stack.pop();
            }
            right[i] = stack.empty() ? len : stack.top();
            stack.push(i);
        }

        // Calculate the maximum area
        int maxArea = 0;
        for (int i = 0; i < len; i++)
        {
            int width = right[i] - left[i] - 1;
            int area = heights[i] * width;
            maxArea = max(maxArea, area);
        }

        return maxArea;
    }
};

int main()
{
    Solution sol;

    // Test case 1
    vector<vector<char> > matrix1 = {
        {'1', '0', '1', '0', '0'},
        {'1', '0', '1', '1', '1'},
        {'1', '1', '1', '1', '1'},
        {'1', '0', '0', '1', '0'}};
    cout << sol.maximalRectangle(matrix1) << endl; // Expected output: 6

    // Test case 2
    vector<vector<char> > matrix2 = {
        {'0'}};
    cout << sol.maximalRectangle(matrix2) << endl; // Expected output: 0

    // Test case 3
    vector<vector<char> > matrix3 = {
        {'1'}};
    cout << sol.maximalRectangle(matrix3) << endl; // Expected output: 1

    return 0;
}
