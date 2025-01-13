#include <iostream>
#include <vector>
using namespace std;

// Perform Depth First Search
void DFS(vector<vector<int> > &grid, int i, int j, int row, int col)
{
    // Boundary conditions
    if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] == 0)
    {
        return;
    }

    // Mark the cell as visited
    grid[i][j] = 0;

    // Explore all 4 directions
    DFS(grid, i - 1, j, row, col); // Up
    DFS(grid, i + 1, j, row, col); // Down
    DFS(grid, i, j - 1, row, col); // Left
    DFS(grid, i, j + 1, row, col); // Right
}

// Count the number of islands
int countIslands(vector<vector<int> > &grid)
{
    int row = grid.size(), col = grid[0].size();
    int count = 0;

    for (int i = 0; i < row; i++)
    {
        for (int j = 0; j < col; j++)
        {
            if (grid[i][j] == 1)
            {
                count++;
                DFS(grid, i, j, row, col);
            }
        }
    }

    return count;
}

int main()
{
    vector<vector<int> > grid = {
        {1, 1, 0, 0, 0},
        {1, 1, 0, 0, 0},
        {0, 0, 1, 0, 0},
        {0, 0, 0, 1, 1}};

    cout << "Number of islands: " << countIslands(grid) << endl;
    return 0;
}
