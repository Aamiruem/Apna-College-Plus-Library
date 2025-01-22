#include <iostream>
#include <vector>
using namespace std;

class ClimbingStairs
{
public:
    int climbStair(int n)
    {
        if (n == 0)
        {
            return 1;
        }
        if (n == 1)
        {
            return 1;
        }
        if (n == 2)
        {
            return 2;
        }

        vector<int> dp(n + 1);
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++)
        {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
};

int main()
{
    ClimbingStairs obj;

    // Test case 1
    int n = 3;
    cout << "Number of ways to climb " << n << " stairs: " << obj.climbStair(n) << endl; // Output: 3

    // Test case 2
    n = 4;
    cout << "Number of ways to climb " << n << " stairs: " << obj.climbStair(n) << endl; // Output: 5

    return 0;
}
