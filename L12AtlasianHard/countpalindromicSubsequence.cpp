#include <bits/stdc++.h>
using namespace std;

const int MOD = 1e9 + 7;
int pre[1000][10][10], suf[1000][10][10];

int main()
{
    string s = "103301";
    int n = s.size();

    vector<int> cnts(10, 0);

    // Compute prefix occurrences
    for (int i = 0; i < n; i++)
    {
        int dig = s[i] - '0';

        if (i >= 1)
        {
            for (int j = 0; j <= 9; j++)
            {
                for (int k = 0; k <= 9; k++)
                {
                    pre[i][j][k] = pre[i - 1][j][k];
                }
            }
        }

        for (int j = 0; j <= 9; j++)
        {
            pre[i][j][dig] += cnts[j];
            pre[i][j][dig] %= MOD;
        }

        cnts[dig]++;
    }

    // Reset cnts for suffix computation
    fill(cnts.begin(), cnts.end(), 0);

    // Compute suffix occurrences
    for (int i = n - 1; i >= 0; i--)
    {
        int dig = s[i] - '0';

        if (i < n - 1)
        {
            for (int j = 0; j <= 9; j++)
            {
                for (int k = 0; k <= 9; k++)
                {
                    suf[i][j][k] = suf[i + 1][j][k];
                }
            }
        }

        for (int j = 0; j <= 9; j++)
        {
            suf[i][j][dig] += cnts[j];
            suf[i][j][dig] %= MOD;
        }

        cnts[dig]++;
    }

    // Compute the final answer
    int ans = 0;
    for (int i = 1; i < n - 1; i++)
    { // Ensure valid range
        for (int j = 0; j <= 9; j++)
        {
            for (int k = 0; k <= 9; k++)
            {
                ans = (ans + (1LL * pre[i - 1][j][k] * suf[i + 1][j][k]) % MOD) % MOD;
            }
        }
    }

    cout << ans << endl;
    return 0;
}
