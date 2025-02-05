#include <iostream>
#include <vector>
using namespace std;

class SuperEggDrop
{
public:
    int superEggDrop(int K, int N)
    {
        vector<vector<int> > dp(K + 1, vector<int>(N + 1, 0));

        // Base cases
        for (int i = 1; i <= K; i++)
            dp[i][1] = 1; // 1 floor, 1 attempt
        for (int j = 1; j <= N; j++)
            dp[1][j] = j; // 1 egg, linear attempts

        for (int k = 2; k <= K; k++)
        {
            for (int n = 2; n <= N; n++)
            {
                int low = 1, high = n, res = n;

                // Binary search to find the best floor to drop from
                while (low <= high)
                {
                    int mid = (low + high) / 2;
                    int breakCase = dp[k - 1][mid - 1]; // Egg breaks
                    int noBreakCase = dp[k][n - mid];   // Egg doesn't break
                    int worst = max(breakCase, noBreakCase) + 1;
                    res = min(res, worst);

                    if (breakCase > noBreakCase)
                    {
                        high = mid - 1; // Try lower floors
                    }
                    else
                    {
                        low = mid + 1; // Try higher floors
                    }
                }
                dp[k][n] = res;
            }
        }
        return dp[K][N];
    }
};

int main()
{
    SuperEggDrop obj;
    cout << obj.superEggDrop(2, 6) << endl; // Output: 3
    return 0;
}
