// #include <iostream>
// #include <vector>
// #include <cmath>
// #include <climits>
// using namespace std;

// int raceCar(int target)
// {
//     vector<int> dp(target + 1, INT_MAX);

//     for (int i = 1; i <= target; i++)
//     {
//         int n = 1;
//         while ((1 << n) - 1 < i)
//         {
//             n++;
//         }

//         // Case 1: Exact match with (2^n - 1)
//         if ((1 << n) - 1 == i)
//         {
//             dp[i] = n;
//             continue;
//         }

//         // Case 2: Overshoot and reverse
//         dp[i] = min(dp[i], n + 1 + dp[(1 << n) - 1 - i]);

//         // Case 3: Undershoot and reverse
//         for (int m = 0; m < n - 1; m++)
//         {
//             dp[i] = min(dp[i], m + 1 + dp[i - (1 << (n - 1)) - (1 << m)]);
//         }
//     }

//     return dp[target];
// }

// int main()
// {
//     int target = 3;
//     cout << raceCar(target) << endl; // Output: 2
//     return 0;
// }










#include <iostream>
#include <vector>
#include <cmath>
#include <climits>
using namespace std;

int racecar(int target)
{
    vector<int> dp(target + 1, INT_MAX);

    for (int i = 1; i <= target; i++)
    {
        int n = 1;
        while (pow(2, n) - 1 < i)
        {
            n++;
        }

        // Case 1: Exact match with (2^n - 1)
        if (pow(2, n) - 1 == i)
        {
            dp[i] = n;
            continue;
        }

        // Case 2: Overshoot and reverse
        dp[i] = min(dp[i], n + 1 + dp[(int)(pow(2, n) - 1 - i)]);

        // Case 3: Undershoot and reverse
        for (int m = 0; m < n - 1; m++)
        {
            dp[i] = min(dp[i], n + m + 1 + dp[i - (int)(pow(2, n - 1) - pow(2, m))]);
        }
    }

    return dp[target];
}

int main()
{
    int target = 3;
    cout << racecar(target) << endl; // Output: 2
    return 0;
}
