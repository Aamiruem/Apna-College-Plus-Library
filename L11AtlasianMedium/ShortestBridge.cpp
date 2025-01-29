#include <bits/stdc++.h>
using namespace std;

const int DX[4] = {-1, 1, 0, 0};
const int DY[4] = {0, 0, -1, 1};

// DFS to mark the first island and add its boundary to the queue
void dfs(vector<vector<int> > &grid, int i, int j, queue<vector<int> > &q)
{
    int n = grid.size(), m = grid[0].size();
    grid[i][j] = 2;    // Mark as visited
    q.push({i, j, 0}); // Add to BFS queue

    for (int k = 0; k < 4; k++)
    {
        int nx = i + DX[k];
        int ny = j + DY[k];

        if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 1)
        {
            dfs(grid, nx, ny, q);
        }
    }
}

// BFS to find the shortest bridge
int bfs(vector<vector<int> > &grid, queue<vector<int> > &q)
{
    int n = grid.size(), m = grid[0].size();

    while (!q.empty())
    {
        auto front = q.front();
        q.pop();
        int x = front[0], y = front[1], distance = front[2];

        for (int k = 0; k < 4; k++)
        {
            int nx = x + DX[k];
            int ny = y + DY[k];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m)
            {
                if (grid[nx][ny] == 1)
                {
                    return distance; // Found the second island
                }
                else if (grid[nx][ny] == 0)
                {
                    q.push({nx, ny, distance + 1});
                    grid[nx][ny] = 2; // Mark as visited
                }
            }
        }
    }
    return -1; // Should not reach here
}

int main()
{
    vector<vector<int> > grid = {
        {1, 0, 0, 0},
        {1, 0, 0, 0},
        {1, 0, 0, 1},
        {0, 0, 0, 1},
        {0, 0, 0, 1}};

    int n = grid.size(), m = grid[0].size();
    queue<vector<int> > q;
    bool found = false;

    // Find and mark the first island using DFS
    for (int i = 0; i < n && !found; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (grid[i][j] == 1)
            {
                dfs(grid, i, j, q);
                found = true;
                break;
            }
        }
    }

    // Run BFS to find the shortest bridge
    int ans = bfs(grid, q);
    cout << ans << endl;

    return 0;
}
