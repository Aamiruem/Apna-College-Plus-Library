#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

class LongestIncreasingPath
{
private:
    vector<vector<int> > directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    vector<vector<int> > dp;

    int dfs(vector<vector<int> > &matrix, int row, int col)
    {
        if (dp[row][col] != 0)
        {
            return dp[row][col];
        }

        int maxLength = 1;
        for (auto &dir : directions)
        {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < matrix.size() && newCol >= 0 && newCol < matrix[0].size() &&
                matrix[newRow][newCol] > matrix[row][col])
            {
                maxLength = max(maxLength, 1 + dfs(matrix, newRow, newCol));
            }
        }

        dp[row][col] = maxLength;
        return maxLength;
    }

public:
    int longestIncreasingPath(vector<vector<int> > &matrix)
    {
        if (matrix.empty() || matrix[0].empty())
        {
            return 0;
        }

        int rows = matrix.size(), cols = matrix[0].size();
        dp = vector<vector<int> >(rows, vector<int>(cols, 0));
        int maxLength = 0;

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                maxLength = max(maxLength, dfs(matrix, i, j));
            }
        }

        return maxLength;
    }
};

int main()
{
    LongestIncreasingPath obj;

    vector<vector<int> > matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    cout << obj.longestIncreasingPath(matrix1) << endl; // Output: 9

    vector<vector<int> > matrix2 = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
    cout << obj.longestIncreasingPath(matrix2) << endl; // Output: 4

    vector<vector<int> > matrix3 = {{1, 2, 3}, {5, 6, 7}, {9, 10, 11}};
    cout << obj.longestIncreasingPath(matrix3) << endl; // Output: 9

    vector<vector<int> > matrix4 = {{1, 2, 4}, {5, 6, 8}, {9, 10, 12}};
    cout << obj.longestIncreasingPath(matrix4) << endl; // Output: 9

    return 0;
}
