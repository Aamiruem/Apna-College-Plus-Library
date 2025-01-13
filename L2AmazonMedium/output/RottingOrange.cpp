#include <iostream>
#include <vector>
#include <queue>
#include <utility>

using namespace std;

int orangeRotting(vector<vector<int> > &grid)
{
    if (grid.empty())
    {
        return -1;
    }

    int rows = grid.size();
    int cols = grid[0].size();
    int countFresh = 0;
    queue<pair<int, int> > q;

    // Initialize the queue with all rotten oranges and count fresh oranges
    for (int i = 0; i < rows; i++)
    {
        for (int j = 0; j < cols; j++)
        {
            if (grid[i][j] == 2)
            {
                q.push({i, j});
            }
            else if (grid[i][j] == 1)
            {
                countFresh++;
            }
        }
    }

    // If there are no fresh oranges, return 0
    if (countFresh == 0)
    {
        return 0;
    }

    int minutes = 0;
    vector<pair<int, int> > directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up, Down, Left, Right

    // Perform BFS
    while (!q.empty())
    {
        int size = q.size();
        bool rotted = false;

        for (int i = 0; i < size; i++)
        {
            pair<int, int> current = q.front();
            q.pop();
            int x = current.first;
            int y = current.second;

            for (auto dir : directions)
            {
                int newX = x + dir.first;
                int newY = y + dir.second;

                // Check if the new position is valid and contains a fresh orange
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == 1)
                {
                    grid[newX][newY] = 2; // Rot the fresh orange
                    q.push({newX, newY});
                    countFresh--; // Decrease the count of fresh oranges
                    rotted = true;
                }
            }
        }

        if (rotted)
        {
            minutes++;
        }
    }

    // If there are still fresh oranges left, return -1
    return countFresh == 0 ? minutes : -1;
}

int main()
{
    vector<vector<int> > grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}; // Example input grid
    int minutes = orangeRotting(grid);
    cout << "Minutes required to rot all oranges: " << minutes << endl;
    return 0;
}
