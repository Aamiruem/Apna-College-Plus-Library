#include <iostream>
#include <vector>

using namespace std;

// Possible moves of a knight in chess
const vector<pair<int, int> > moves = {
    {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

double knightProbability(int N, int K, int row, int column)
{
    // DP table: dp[k][r][c] stores probability of being on (r, c) after k moves
    vector<vector<vector<double> > > dp(K + 1, vector<vector<double> >(N, vector<double>(N, 0.0)));
    dp[0][row][column] = 1.0; // Initially, knight is at (row, column) with 100% probability

    // Loop for each move from 1 to K
    for (int k = 1; k <= K; k++)
    {
        vector<vector<double> > temp(N, vector<double>(N, 0.0)); // Temporary table for k-th move
        for (int r = 0; r < N; r++)
        {
            for (int c = 0; c < N; c++)
            {
                if (dp[k - 1][r][c] > 0)
                { // Only process valid positions
                    for (auto move : moves)
                    {
                        int nr = r + move.first;  // New row
                        int nc = c + move.second; // New column
                        if (nr >= 0 && nr < N && nc >= 0 && nc < N)
                        {
                            temp[nr][nc] += dp[k - 1][r][c] / 8.0; // Each move has 1/8 probability
                        }
                    }
                }
            }
        }
        dp[k] = temp; // Update DP table
    }

    // Sum up probabilities of being on board after K moves
    double probability = 0.0;
    for (int r = 0; r < N; r++)
    {
        for (int c = 0; c < N; c++)
        {
            probability += dp[K][r][c];
        }
    }
    return probability;
}

int main()
{
    int N = 3, K = 2, row = 0, column = 0;
    cout << knightProbability(N, K, row, column) << endl; // Output: 0.0625
    return 0;
}
