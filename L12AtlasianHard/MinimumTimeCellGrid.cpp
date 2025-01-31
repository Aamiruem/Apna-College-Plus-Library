#include <bits/stdc++.h>
using namespace std;

int minPathCost(vector<vector<int> > &grid)
{
    int n = grid.size();
    int m = grid[0].size();

    // Min-heap (Dijkstra’s Algorithm)
    priority_queue<pair<int, pair<int, int> >, vector<pair<int, pair<int, int> > >, greater<pair<int, pair<int, int> > > > pq;

    // Distance array (initialize with max value)
    vector<vector<int> > vis(n, vector<int>(m, INT_MAX));

    // Start from (0,0) with initial weight 0
    pq.push({0, {0, 0}});
    vis[0][0] = 0;

    // Direction vectors for moving in 4 directions (Up, Down, Left, Right)
    int dx[4] = {-1, 1, 0, 0};
    int dy[4] = {0, 0, -1, 1};

    while (!pq.empty())
    {
        auto tp = pq.top();
        pq.pop();

        int wt = tp.first;
        int x = tp.second.first;
        int y = tp.second.second;

        // If we reached the last cell, return the cost
        if (x == n - 1 && y == m - 1)
        {
            return wt;
        }

        // Explore all 4 possible moves
        for (int i = 0; i < 4; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // Check if inside grid bounds
            if (nx >= 0 && ny >= 0 && nx < n && ny < m)
            {
                int newCost = wt + (grid[nx][ny] % 2 == 0 ? 1 : grid[nx][ny]);

                if (newCost < vis[nx][ny])
                {
                    vis[nx][ny] = newCost;
                    pq.push({newCost, {nx, ny}});
                }
            }
        }
    }

    return -1; // If path is not found (should not happen for valid grids)
}

int main()
{
    vector<vector<int> > grid = {
        {0, 1, 3, 2},
        {5, 1, 2, 5},
        {4, 3, 8, 6}};

    cout << "Minimum Path Cost: " << minPathCost(grid) << endl;
    return 0;
}
