#include <bits/stdc++.h>
using namespace std;

int main()
{
    vector<string> words = {"acca", "bbbb", "caca"};
    string target = "aba";
    const int mod = 1000000007;
    int colSize = words[0].size();

    // Count occurrences of each character in each column
    vector<vector<int> > occur(26, vector<int>(colSize, 0));
    for (int i = 0; i < colSize; ++i)
    {
        for (auto &s : words)
        {
            occur[s[i] - 'a'][i]++;
        }
    }

    int n = target.size();
    vector<vector<int> > dp(n + 1, vector<int>(colSize + 1, 0));

    // Initialize DP table
    dp[0][0] = 1;
    for (int j = 1; j <= colSize; ++j)
    {
        dp[0][j] = 1; // One way to form an empty string using any number of columns
    }

    for (int i = 1; i <= n; ++i)
    {
        dp[i][0] = 0; // Zero ways to form a non-empty string using zero columns
    }

    // Fill DP table
    for (int i = 1; i <= n; ++i)
    {
        for (int j = 1; j <= colSize; ++j)
        {
            char c = target[i - 1];
            int cnt = occur[c - 'a'][j - 1];                       // Count of target character in the current column
            long long ways = (1LL * cnt * dp[i - 1][j - 1]) % mod; // Ways if we pick this column
            dp[i][j] = (dp[i][j - 1] + ways) % mod;                // Total ways = ways if we leave this column + ways if we pick this column
        }
    }

    cout << dp[n][colSize]; // Print the result
    return 0;
}

// words = {"acca", "bbbb", "caca"} target = "aba"
