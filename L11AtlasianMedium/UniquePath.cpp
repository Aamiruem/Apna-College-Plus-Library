#include <bits/stdc++.h>
using namespace std;

int main()
{
    vector<vector<int> > grid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
    int n = grid.size();
    int m = grid[0].size();
    vector<vector<int> > dp(n, vector<int>(m, 0));

    dp[n - 1][m - 1] = (grid[n - 1][m - 1] == 0) ? 1 : 0; // Base case

    for (int i = n - 1; i >= 0; i--)
    {
        for (int j = m - 1; j >= 0; j--)
        {
            if (grid[i][j] == 1)
            {
                dp[i][j] = 0;
                continue;
            }
            if (i + 1 < n)
            {
                dp[i][j] += dp[i + 1][j];
            }
            if (j + 1 < m)
            {
                dp[i][j] += dp[i][j + 1];
            }
        }
    }

    cout << dp[0][0] << "\n";
    return 0;
}
