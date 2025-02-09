#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    int empty = 1; // Count of empty cells (including the starting cell)
    int res = 0;   // Result to store the number of unique paths

    void dfs(vector<vector<int> > &grid, int x, int y, int count)
    {
        // Boundary checks and obstacle checks
        if (x < 0 || x >= grid.size() || y < 0 || y >= grid[0].size() || grid[x][y] == -1)
        {
            return;
        }

        // If reached the ending cell
        if (grid[x][y] == 2)
        {
            if (empty == count)
            { // If all empty cells are covered
                res++;
            }
            return;
        }

        // Mark the current cell as visited
        grid[x][y] = -1;

        // Explore all four directions
        dfs(grid, x + 1, y, count + 1);
        dfs(grid, x - 1, y, count + 1);
        dfs(grid, x, y + 1, count + 1);
        dfs(grid, x, y - 1, count + 1);

        // Backtrack: Unmark the current cell
        grid[x][y] = 0;
    }

    int uniquePathsIII(vector<vector<int> > &grid)
    {
        int start_x = 0, start_y = 0;

        // Find the starting cell and count empty cells
        for (int i = 0; i < grid.size(); i++)
        {
            for (int j = 0; j < grid[0].size(); j++)
            {
                if (grid[i][j] == 1)
                {
                    start_x = i;
                    start_y = j;
                }
                else if (grid[i][j] == 0)
                {
                    empty++;
                }
            }
        }

        // Start DFS from the starting cell
        dfs(grid, start_x, start_y, 0);

        return res;
    }
};

int main()
{
    Solution solution;
    vector<vector<int> > grid = {
        {1, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 2, -1}};

    int uniquePaths = solution.uniquePathsIII(grid);
    cout << "Number of Unique Paths: " << uniquePaths << endl;

    return 0;
}
